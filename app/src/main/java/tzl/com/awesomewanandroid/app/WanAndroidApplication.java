package tzl.com.awesomewanandroid.app;

import android.content.Context;
import android.os.Looper;
import android.webkit.WebView;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.tencent.bugly.crashreport.CrashReport;

import me.jessyan.autosize.AutoSizeConfig;
import tzl.com.framework.base.BaseApplication;
import tzl.com.framework.helper.AppExecutors;
import tzl.com.framework.helper.LogHelper;

/**
 * author: tangzenglei
 * created on: 2018/7/10 下午3:48
 * description:
 */
public class WanAndroidApplication extends BaseApplication {

    private  RefWatcher mRefWatcher;
//    private WebView mWebView;


    @Override
    protected void init() {
        //内存泄漏检测工具
        mRefWatcher = setupLeakCanary();
        long start_bugly = System.currentTimeMillis();
        initBugly();
        long end_bugly = System.currentTimeMillis();
        LogHelper.e( "testBuglyFirstInit use time:" + (start_bugly-end_bugly));
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                testWebView();
                testWebView();
                Looper.loop();
            }
        });
        AutoSizeConfig.getInstance().setCustomFragment(true);



    }

    private void testWebView() {
        long start_webView = System.currentTimeMillis();
        WebView webView = new WebView(this);
        long end_webView = System.currentTimeMillis();
        LogHelper.e("testWebviewFirstInit use time:" + (end_webView-start_webView));
    }

    private void initBugly() {
        CrashReport.initCrashReport(getApplicationContext(), "62066e4106", false);
    }

    @Override
    public boolean logToggle() {
        return true;
    }

    @Override
    public String tag() {
        return "wanAndroid";
    }

    private RefWatcher setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return RefWatcher.DISABLED;
        }
        return LeakCanary.install(this);
    }


    public static RefWatcher getRefWatcher(Context context) {
        WanAndroidApplication application = (WanAndroidApplication) context.getApplicationContext();
        return application.mRefWatcher;
    }



}
