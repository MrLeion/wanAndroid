package tzl.com.awesomewanandroid.testExample;

import android.os.Bundle;

import com.squareup.leakcanary.RefWatcher;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.activity.BaseActivity;
import tzl.com.awesomewanandroid.app.WanAndroidApplication;


/**
 * LeakCanary 测试类
 */
public class LeakCanaryTestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_canary_test);
        new LeakThread().start();
    }


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
}
