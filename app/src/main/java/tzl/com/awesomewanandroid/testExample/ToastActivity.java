package tzl.com.awesomewanandroid.testExample;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.ref.SoftReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import tzl.com.awesomewanandroid.R;
import tzl.com.framework.data.AppConfig;
import tzl.com.framework.helper.LogHelper;

public class ToastActivity extends AppCompatActivity {


    @BindView(R.id.message)
    TextView       mMessage;
    @BindView(R.id.rlToast)
    RelativeLayout mRlToast;
    private WorkHandler mWorkHandler;
    private static final int MSG_FINISH = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        setContentView(R.layout.activity_toast);
        ButterKnife.bind(this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            String msg = bundle.getString(AppConfig.TOAST_MSG);
            mMessage.setText(msg);
        }


        ObjectAnimator animator = ObjectAnimator.ofFloat(mMessage, "alpha",  0f, 1f);
        animator.setDuration(500);
        animator.start();
        mWorkHandler = new WorkHandler(this);
        Message msg = Message.obtain();
        msg.what = MSG_FINISH;
        mWorkHandler.sendMessageDelayed(msg, 1000);
    }



    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        finish();
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }


    private class WorkHandler extends Handler {

        private final SoftReference<ToastActivity> mActivity;


        private WorkHandler(ToastActivity activity) {
            mActivity = new SoftReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_FINISH:
                    if (mActivity.get() != null) {
                        LogHelper.e("finish");
                        mActivity.get().finish();
                    }
                    break;
            }
        }
    }


}
