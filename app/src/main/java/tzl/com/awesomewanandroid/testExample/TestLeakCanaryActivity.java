package tzl.com.awesomewanandroid.testExample;

import com.squareup.leakcanary.RefWatcher;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.app.WanAndroidApplication;
import tzl.com.awesomewanandroid.base.WBaseActivity;


/**
 * LeakCanary 测试类
 */
public class TestLeakCanaryActivity extends WBaseActivity {



    class LeakThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(6 * 60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = WanAndroidApplication.getRefWatcher(this);//1
        refWatcher.watch(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_leak_canary_test;
    }

    @Override
    public void initView() {
        new LeakThread().start();
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initData() {

    }
}
