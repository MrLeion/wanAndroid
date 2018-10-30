package tzl.com.framework.widget.cardView;

import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * author: tangzenglei
 * created on: 2018/10/30 下午4:29
 * description:
 */
@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
public class CardViewApi17Impl extends CardViewBaseImpl {

    @Override
    public void initStatic() {
        RoundRectDrawableWithShadow.sRoundRectHelper =
                (canvas, bounds, cornerRadius, paint) -> canvas.drawRoundRect(bounds, cornerRadius, cornerRadius, paint);
    }
}
