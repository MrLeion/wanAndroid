package tzl.com.framework.widget.anim;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.widget.FrameLayout;

/**
 * author: tangzenglei
 * created on: 2018/8/27 下午7:59
 * description:
 */
public class Rotate3dFrameLayout extends FrameLayout {


    private View childView1;
    private View childView2;
    private float mCenterX;
    private float mCenterY;
    private int Duration = 200;
    private boolean mIsFirst;

    public Rotate3dFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public Rotate3dFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Rotate3dFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //子View的数量
        int childCount = getChildCount();
        Log.e("111", "childCount=========" + childCount);
        if (childCount != 2) {
            throw new IllegalArgumentException("Rotate3dFrameLayout的子View数量必须为2");
        }

        childView1 = getChildAt(0);
        childView2 = getChildAt(1);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mCenterX = w / 2;
        mCenterY = h / 2;
        Log.e("111", "mCenterX=========" + mCenterX);
        Log.e("111", "mCenterY=========" + mCenterY);
    }

    public void applyRotation(boolean isFirst) {
        Rotate3dAnimation rotation = null;
        mIsFirst = isFirst;
        float mDepthZ = 300.0f;
        if (mIsFirst) {
            rotation = new Rotate3dAnimation(0, 90, mCenterX, mCenterY, mDepthZ, true);
        } else {
            rotation = new Rotate3dAnimation(0, -90, mCenterX, mCenterY, mDepthZ, true);
        }

        rotation.setDuration(Duration);
        rotation.setFillAfter(true);
        rotation.setInterpolator(new AccelerateDecelerateInterpolator());
        rotation.setAnimationListener(new DisplayNextView());

        startAnimation(rotation);
    }

    private final class DisplayNextView implements Animation.AnimationListener {

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            post(new SwapViews());
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    private final class SwapViews implements Runnable {
        @Override
        public void run() {
            Rotate3dAnimation rotation = null;

            if (mIsFirst) {
                childView1.setVisibility(View.GONE);
                childView2.setVisibility(View.VISIBLE);
                rotation = new Rotate3dAnimation(-90, 0, mCenterX, mCenterY, 310.0f, false);
            } else {
                childView1.setVisibility(View.VISIBLE);
                childView2.setVisibility(View.GONE);
                rotation = new Rotate3dAnimation(90, 0, mCenterX, mCenterY, 310.0f, false);
            }

            rotation.setDuration(Duration);//设置动画持续时间
            rotation.setFillAfter(true);
            rotation.setInterpolator(new AccelerateDecelerateInterpolator());//设置动画变化速度
            startAnimation(rotation);
        }
    }
}
