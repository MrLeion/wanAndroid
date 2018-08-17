package tzl.com.framework.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import tzl.com.framework.helper.ActivityManager;

/**
 * author: tangzenglei
 * created on: 2018/7/27 上午11:02
 * description:
 */
public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.add(this);
    }


    /**
     * 显示加载 DialogLoading
     *
     * @param tip 提示文字
     */
    public abstract void showLoading(String tip);

    public void showLoading() {
        showLoading("加载中...");
    }


    public abstract void dismissLoading();








    @Override
    protected void onResume() {
        ActivityManager.setTopActivity(this);
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.remove(this);
        System.gc();
    }



}
