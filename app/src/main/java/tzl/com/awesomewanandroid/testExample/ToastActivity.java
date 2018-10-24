package tzl.com.awesomewanandroid.testExample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.ref.SoftReference;

import butterknife.BindView;
import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.base.WBaseActivity;
import tzl.com.framework.data.AppConfig;
import tzl.com.framework.helper.LogHelper;
import tzl.com.framework.widget.listener.OnViewClickListener;

public class ToastActivity extends WBaseActivity {


    private static final int MSG_FINISH = 0;
    @BindView(R.id.message)
    TextView       mMessage;
    @BindView(R.id.rlToast)
    RelativeLayout mRlToast;
    private WorkHandler mWorkHandler;

    @Override
    public int getLayoutId() {
        return R.layout.activity_toast;
    }

    @Override
    public void initView() {
        if (getIntent() != null && getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            String msg = bundle.getString(AppConfig.TOAST_MSG);
            mMessage.setText(msg);
        }
        mRlToast.setOnClickListener(new OnViewClickListener() {
            @Override
            public void onViewOnClick(View v) {
                finish();
            }
        });


        mWorkHandler = new WorkHandler(this);
        Message msg = Message.obtain();
        msg.what = MSG_FINISH;
        mWorkHandler.sendMessageDelayed(msg, 1000);


    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initData() {

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
