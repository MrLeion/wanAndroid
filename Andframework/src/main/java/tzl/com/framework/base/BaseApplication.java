package tzl.com.framework.base;

import android.app.Application;

import tzl.com.framework.cache.CacheManager;
import tzl.com.framework.helper.ContextHolder;
import tzl.com.framework.helper.LogHelper;

/**
 * author: tangzenglei
 * created on: 2018/7/31 下午5:29
 * description:
 */
public abstract class BaseApplication extends Application {


    public static final boolean DEUG = false;

    @Override
    public void onCreate() {
        super.onCreate();
        LogHelper.init(tag(),logToggle());
        ContextHolder.init(this);
        CacheManager.init(this);

    }




    /**
     * @return true is to open Logcat,or close the logcat by false
     */
    public abstract  boolean logToggle();

    /**
     * module 根据自身去继承
     *
     * @return
     */
    public abstract String tag();




}
