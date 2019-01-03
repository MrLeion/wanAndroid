package tzl.com.framework.base;

import android.app.Application;
import android.os.Process;

import tzl.com.framework.cache.CacheManager;
import tzl.com.framework.detector.ui.IBlockDetector;
import tzl.com.framework.detector.ui.PrinterBlockDetector;
import tzl.com.framework.helper.ContextHolder;
import tzl.com.framework.helper.LogHelper;
import tzl.com.framework.helper.Util;

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

        //UI 卡顿检测
        IBlockDetector detector = new PrinterBlockDetector();
        detector.start();
        LogHelper.e("current process id:"+ Process.myPid()+ Util.getProcessName(this));
        LogHelper.init(tag(),logToggle());
        ContextHolder.init(this);
        CacheManager.init(this);
        init();

    }

    protected abstract void init();


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
