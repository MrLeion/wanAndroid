package tzl.com.framework.widget.toastCompat;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import tzl.com.framework.helper.DensityHelper;

/**
 * author: tangzenglei
 * created on: 2018/10/26 下午4:58
 * description: 将 NotificationManagerService 中的权限判断移除
 */
public class PermissonRemoveToastCompat {


    public static final  int                                       LENGTH_LONG    = 3500;
    public static final  int                                       LENGTH_SHORT   = 2*1000;
    static final         String                                    TAG            = "PermissonRemoveToastCompat";
    private static final Runnable                                  mActivite      = new Runnable() {
        public void run() {
            PermissonRemoveToastCompat.activeQueue();
        }
    };
    protected static     AtomicInteger                             mAtomicInteger = new AtomicInteger(0);
    private static       Handler                                   mHanlder       = new Handler();
    private static       BlockingQueue<PermissonRemoveToastCompat> mQueue         = new LinkedBlockingQueue();
    final Context mContext;
    long mDuration;
    View mView;
    private WindowManager mWM;

    private final Runnable mHide = new Runnable() {
        public void run() {
            PermissonRemoveToastCompat.this.handleHide();
        }
    };
    private WindowManager.LayoutParams mParams;
    private final Runnable mShow = new Runnable() {
        public void run() {
            PermissonRemoveToastCompat.this.handleShow();
        }
    };


    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {
    }

    @SuppressWarnings("ResourceType")
    public PermissonRemoveToastCompat(Context context) {
        this.mContext = context;
        this.mParams = new WindowManager.LayoutParams();
        this.mParams.height =  WindowManager.LayoutParams.WRAP_CONTENT;
        this.mParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        this.mParams.format = PixelFormat.TRANSPARENT;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.mParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else {
            this.mParams.type = WindowManager.LayoutParams.TYPE_PHONE;
        }
        this.mWM = (WindowManager) context.getSystemService("window");
        this.mParams.packageName = context.getPackageName();
    }

    public static PermissonRemoveToastCompat makeText(Context context, CharSequence text, int duration) {
        return new PermissonRemoveToastCompat(context)
                .setText(text)
                .setDuration(duration)
                .setGravity(80, 0,
                DensityHelper.dp2px(context, 64.0f));
    }

    public static PermissonRemoveToastCompat makeText(Context context, int resId, int duration) throws
            Resources.NotFoundException {
        return makeText(context, context.getResources().getText(resId), duration);
    }

    public PermissonRemoveToastCompat setView(View view) {
        this.mView = view;
        return this;
    }

    public View getView() {
        return this.mView;
    }

    @TargetApi(17)
    public PermissonRemoveToastCompat setGravity(int gravity, int xOffset, int yOffset) {
        int finalGravity = gravity;
        this.mParams.gravity = finalGravity;
        if ((finalGravity & 7) == 7) {
            this.mParams.horizontalWeight = 1.0f;
        }
        if ((finalGravity & 112) == 112) {
            this.mParams.verticalWeight = 1.0f;
        }
        this.mParams.y = yOffset;
        this.mParams.x = xOffset;
        return this;
    }

    public PermissonRemoveToastCompat setDuration(int duration) {
         this.mDuration = duration;
        return this;
    }

    public PermissonRemoveToastCompat setText(int resId) {
        setText(this.mContext.getText(resId));
        return this;
    }

    @SuppressWarnings("ResourceType")
    public PermissonRemoveToastCompat setText(CharSequence s) {
        View view = Toast.makeText(this.mContext, s, 0).getView();
        if (view != null) {
            ((TextView) view.findViewById(16908299)).setText(s);
            setView(view);
        }
        return this;
    }

    public void show() {
        mQueue.offer(this);
        if (mAtomicInteger.get() == 0) {
            mAtomicInteger.incrementAndGet();
            mHanlder.post(mActivite);
        }
    }

    public void cancel() {
        if (!(mAtomicInteger.get() == 0 && mQueue.isEmpty()) && equals(mQueue.peek())) {
            mHanlder.removeCallbacks(mActivite);
            mHanlder.post(this.mHide);
            mHanlder.post(mActivite);
        }
    }

    private void handleShow() {
        if (this.mView != null) {
            if (this.mView.getParent() != null) {
                this.mWM.removeView(this.mView);
            }
            this.mWM.addView(this.mView, this.mParams);
        }
    }

    private void handleHide() {
        if (this.mView != null) {
            if (this.mView.getParent() != null) {
                this.mWM.removeView(this.mView);
                mQueue.poll();
            }
            this.mView = null;
        }
    }

    private static void activeQueue() {
        PermissonRemoveToastCompat toast = (PermissonRemoveToastCompat) mQueue.peek();
        if (toast == null) {
            mAtomicInteger.decrementAndGet();
            return;
        }
        mHanlder.post(toast.mShow);
        mHanlder.postDelayed(toast.mHide, toast.mDuration);
        mHanlder.postDelayed(mActivite, toast.mDuration);
    }
}
