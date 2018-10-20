package tzl.com.framework.widget.recyclerView.layoutManager;

import android.content.Context;
import android.util.TypedValue;

/**
 * author: tangzenglei
 * created on: 2018/10/19 下午1:51
 * description: 卡片常用配置
 */
public class CardConfig {

    public static final int DEFAULT_SHOW_COUNT = 4;
    //屏幕上最多同时显示几个Item
    public static int MAX_SHOW_COUNT;

    //每一级Scale相差0.05f，translationY相差7dp左右
    public static float SCALE_GAP;
    public static int TRANS_Y_GAP;

    public static void initConfig(Context context) {
       initConfig(context,DEFAULT_SHOW_COUNT);
    }


    public static void initConfig(Context context,int displayCount) {
        MAX_SHOW_COUNT = displayCount;
        SCALE_GAP = 0.05f;
        TRANS_Y_GAP = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, context.getResources().getDisplayMetrics());
    }

}
