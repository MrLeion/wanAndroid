package tzl.com.awesomewanandroid.testExample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Button;

import tzl.com.framework.helper.ToastHelper;

/**
 *  Unable to add window android.view.ViewRootImpl$W@bf0df5d -- permission denied for this window type  -----type 为系统类型 但未添加权限
 *  BadTokenException
 */
public class TestWindowManagerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mButton = new Button(this);
//        mButton.setText("按钮");
//        mWindowManager = getWindowManager();
//        WindowManager.LayoutParams params = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT,
//                WindowManager.LayoutParams.WRAP_CONTENT);
//        params.type = WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
//        mWindowManager.addView(mButton, params);


        ToastHelper.showToast("fafa");
    }

    private WindowManager mWindowManager;
    private Button        mButton;


    @Override
    protected void onStop() {
        super.onStop();
        if (mWindowManager!=null) {
            mWindowManager.removeView(mButton);
        }

        mButton = null;
        mWindowManager = null;
    }




}
