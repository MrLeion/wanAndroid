package tzl.com.framework.widget.banner;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * author: tangzenglei
 * created on: 2018/12/18 7:54 PM
 * description:
 */
public class ZoomOutPageTransformer implements ViewPager.PageTransformer {



        private static final float MIN_ALPHA = 0.5f;
        private static final float SPACE = 0.2f;
        private static final float MAX_SCALE = 1.0f;
        private static final float MIN_SCALE = 0.80f;//0.85f

        @SuppressLint("NewApi")
        @Override
        public void transformPage(View view, float position)
        {
            //		int pageWidth = view.getWidth();
            //		int pageHeight = view.getHeight();

            //		Log.e("TAG", view + " , " + position + "");

            if (position < -1)
            { // [-Infinity,-1)
                // This page is way off-screen to the left.
                //			view.setAlpha(0);
                //			view.setScaleX(MIN_ALPHA);
                //			view.setScaleY(MIN_ALPHA);
                view.setScaleX(MIN_SCALE);
                view.setScaleY(MIN_SCALE);
            } else if (position <= 1) //a页滑动至b页 ； a页从 0.0 -1 ；b页从1 ~ 0.0
            {
                Log.e("TAG", view + " , " + position + "");

                float scaleFactor =  MIN_SCALE+(1- Math.abs(position))*(MAX_SCALE-MIN_SCALE);
                view.setScaleX(scaleFactor);
                //少量的偏移，目的是为了适配三星手机在没有绘制
                if(position>0){
                    view.setTranslationX(-scaleFactor*2);
                }else if(position<0){
                    view.setTranslationX(scaleFactor*2);
                }
                view.setScaleY(scaleFactor);

            } else
            {
                view.setScaleX(MIN_SCALE);
                view.setScaleY(MIN_SCALE);
            }
        }

    }
