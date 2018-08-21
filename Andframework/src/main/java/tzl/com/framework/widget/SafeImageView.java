package tzl.com.framework.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

/**
 * @author Maliang
 * @desc 处理8.0 8.1bitmap的问题 Canvas: trying to use a recycled bitmap android.graphics.Bitmap@d4afdac
 * @date 2018/6/7
 */
public class SafeImageView extends android.support.v7.widget.AppCompatImageView {


    public SafeImageView(Context context) {
        super(context);
    }

    public SafeImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SafeImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        try{
            super.onDraw(canvas);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ImageView->onDraw() Canvas: trying to use a recycled bitmap");
        }
    }
}
