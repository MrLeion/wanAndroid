package tzl.com.framework.widget.scrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/**
 * author: tangzenglei
 * created on: 2018/12/25 2:31 PM
 * description: 带阻尼效果的 HorizontalScrollView
 */
public class BounceScrollView extends HorizontalScrollView {

    private static final int MAX_SCROLL = 200;
    private static final float SCROLL_RATIO = 0.5f;// 阻尼系数


    public BounceScrollView(Context context) {
        super(context);
    }

    public BounceScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BounceScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent)
    {
        int newDeltaX = deltaX;
        int delta = (int) (deltaX * SCROLL_RATIO);
        if((scrollX+deltaX)==0 || (scrollX-scrollRangeX+deltaX)==0){
            newDeltaX = deltaX;     //回弹最后一次滚动，复位
        }else{
            newDeltaX = delta;      //增加阻尼效果
        }
        return super.overScrollBy(newDeltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, MAX_SCROLL, maxOverScrollY, isTouchEvent);
    }
}
