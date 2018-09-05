package tzl.com.awesomewanandroid.app;

import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.tencent.bugly.crashreport.CrashReport;

import me.jessyan.autosize.AutoSizeConfig;
import tzl.com.framework.base.BaseApplication;

/**
 * author: tangzenglei
 * created on: 2018/7/10 下午3:48
 * description:
 */
public class WanAndroidApplication extends BaseApplication {

    private  RefWatcher mRefWatcher;


    @Override
    protected void init() {
        //内存泄漏检测工具
        mRefWatcher = setupLeakCanary();
        initBugly();
        AutoSizeConfig.getInstance().setCustomFragment(true);
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
