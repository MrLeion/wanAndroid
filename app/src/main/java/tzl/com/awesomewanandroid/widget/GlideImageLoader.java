package tzl.com.awesomewanandroid.widget;

import android.content.Context;
import android.widget.ImageView;

import com.youth.banner.loader.ImageLoader;

/**
 * author: tangzenglei
 * created on: 2018/10/29 上午10:10
 * description:
 */
public class GlideImageLoader extends ImageLoader {


    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        tzl.com.framework.glide.GlideImageLoader.loadImage(context,imageView,path.toString());
    }
}
