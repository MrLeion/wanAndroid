package tzl.com.toastlibrary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextThemeWrapper;
import android.widget.TextView;

public class ToastActivity extends AppCompatActivity {

    private static final String  TOAST_MSG = "TOAST_MSG";
    private              Handler handler   = new Handler();
    private TextView tvMessage;


    private Runnable finishRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public  static void showToast(Context context, String msg) {
        Intent intent = new Intent(context, ToastActivity.class);
        intent.putExtra(TOAST_MSG,msg);
        if (!(context instanceof ContextThemeWrapper)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        setContentView(R.layout.activity_toast);
        tvMessage = findViewById(R.id.message);
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handler.removeCallbacks(finishRunnable);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (tvMessage != null && intent != null && intent.getExtras() != null) {
            Bundle bundle = intent.getExtras();
            String msg = bundle.getString(TOAST_MSG);
            tvMessage.setText(msg);
            handler.postDelayed(finishRunnable, 1000);
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    protected void onDestroy() {
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }




}
