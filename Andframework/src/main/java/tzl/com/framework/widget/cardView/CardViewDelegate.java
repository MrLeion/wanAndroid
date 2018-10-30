package tzl.com.framework.widget.cardView;

import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * author: tangzenglei
 * created on: 2018/10/30 下午4:24
 * description:
 */
public interface CardViewDelegate {


    Drawable getCardBackground();

    void setCardBackground(Drawable drawable);

    boolean getUseCompatPadding();

    boolean getPreventCornerOverlap();

    void setShadowPadding(int left, int top, int right, int bottom);

    void setMinWidthHeightInternal(int width, int height);

    View getCardView();
}
