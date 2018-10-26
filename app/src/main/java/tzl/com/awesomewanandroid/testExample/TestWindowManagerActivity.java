package tzl.com.awesomewanandroid.testExample;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

public class TestWindowManagerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mButton = new Button(this);
        mButton.setText("按钮");
        mWindowManager = getWindowManager();
        ViewGroup.LayoutParams params = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY, 0
                , PixelFormat.TRANSPARENT
        );
        mWindowManager.addView(mButton, params);


//        Toast.makeText(this, "hello", Toast.LENGTH_LONG).show();


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
