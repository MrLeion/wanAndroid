package tzl.com.framework.widget.cardView;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.Nullable;

/**
 * author: tangzenglei
 * created on: 2018/10/30 下午4:24
 * description:
 */
public interface CardViewImpl {
    void initialize(CardViewDelegate cardView, Context context, ColorStateList backgroundColor,
                    float radius, float elevation, float maxElevation, ColorStateList shadowColorStart, ColorStateList shadowColorEnd);

    void setRadius(CardViewDelegate cardView, float radius);

    float getRadius(CardViewDelegate cardView);

    void setElevation(CardViewDelegate cardView, float elevation);

    float getElevation(CardViewDelegate cardView);

    void initStatic();

    void setMaxElevation(CardViewDelegate cardView, float maxElevation);

    float getMaxElevation(CardViewDelegate cardView);

    float getMinWidth(CardViewDelegate cardView);

    float getMinHeight(CardViewDelegate cardView);

    void updatePadding(CardViewDelegate cardView);

    void onCompatPaddingChanged(CardViewDelegate cardView);

    void onPreventCornerOverlapChanged(CardViewDelegate cardView);

    void setBackgroundColor(CardViewDelegate cardView, @Nullable ColorStateList color);

    ColorStateList getBackgroundColor(CardViewDelegate cardView);

}
