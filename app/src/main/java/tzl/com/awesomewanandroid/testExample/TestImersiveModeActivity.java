package tzl.com.awesomewanandroid.testExample;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.base.WBaseActivity;
import tzl.com.framework.helper.LogHelper;

/**
 * 自 api level 19 有效
 */
public class TestImersiveModeActivity extends WBaseActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_test_immersive_mode;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initData() {


    }



    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
            /**
             * 注意 半透明含有 Layout 字样
             */
            // View.SYSTEM_UI_FLAG_FULLSCREEN 隐藏状态栏 导航栏依然显示
            // View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE getWindow().setStatusBarColor(Color.TRANSPARENT); 半透明状态栏
            //View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN 隐藏虚拟按键导航栏
            //View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE; getWindow().setNavigationBarColor(Color.TRANSPARENT)半透明导航栏栏
            //View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY 沉浸式状态栏
        }
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogHelper.e("onSaveInstanceState");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LogHelper.e("onRestoreInstanceState");
    }
}
