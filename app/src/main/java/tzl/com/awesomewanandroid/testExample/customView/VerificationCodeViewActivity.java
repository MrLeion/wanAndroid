package tzl.com.awesomewanandroid.testExample.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import tzl.com.framework.helper.LogHelper;

/**
 * author: tangzenglei
 * created on: 2018/10/22 上午9:22
 * description:验证码 view
 */
public class VerificationCodeViewActivity extends View {


    public VerificationCodeViewActivity(Context context) {
        this(context,null);
    }

    public VerificationCodeViewActivity(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public VerificationCodeViewActivity(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LogHelper.e("VerificationCodeView() is Called");



    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        LogHelper.e("VerificationCodeView -onMeasure() is Called");


    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        LogHelper.e("VerificationCodeView -onDraw() is Called");

    }
}
