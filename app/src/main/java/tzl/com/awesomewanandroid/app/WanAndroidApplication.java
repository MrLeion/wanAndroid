package tzl.com.awesomewanandroid.app;

import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import tzl.com.framework.base.BaseApplication;

/**
 * author: tangzenglei
 * created on: 2018/7/10 下午3:48
 * description:
 */
public class WanAndroidApplication extends BaseApplication {

    private  RefWatcher mRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        //内存泄漏检测工具
        mRefWatcher = setupLeakCanary();
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
