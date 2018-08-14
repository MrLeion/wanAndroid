package tzl.com.framework.glide;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.request.target.Target;

import tzl.com.framework.glide.transformation.BlurTransformation;
import tzl.com.framework.glide.transformation.CropCirlceTransformation;
import tzl.com.framework.glide.transformation.RoundedCornersTransformation;

/**
 * author: tangzenglei
 * created on: 2018/7/27 上午9:35
 * description: load image over Glide V4.0
 */
public class GlideImageLoader {



    /**
     * 加载图片
     * @param context  context
     * @param iv       imageView
     * @param url      图片地址
     * @param emptyImg 默认展位图
     */
    public static void loadImage(Context context, ImageView iv, String url, int placeId,int emptyImg) {
        if (!TextUtils.isEmpty(url)) {
            GlideApp.with(context)
                    .load(url)
                    .error(emptyImg)
                    .placeholder(placeId)
                    .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .into(iv);
        } else {
            loadImage(context, iv, emptyImg, emptyImg);
        }
    }

    /**
     * 加载圆形图片
     * @param context  context
     * @param iv       imageView
     * @param url      图片地址
     * @param emptyImg 默认展位图
     */
    public static void loadCircle(Context context, ImageView iv, String url, int placeId,int emptyImg) {
        if (!TextUtils.isEmpty(url)) {
            GlideApp.with(context)
                    .load(url)
                    .error(emptyImg)
                    .placeholder(placeId)
                    .transform(new CropCirlceTransformation())
                    .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .into(iv);
        } else {
            loadImage(context, iv, emptyImg, emptyImg);
        }
    }

    /**
     * 加载圆角图片
     * @param context  context
     * @param iv       imageView
     * @param url      图片地址
     * @param emptyImg 默认展位图
     */
    public static void loadRound(Context context, ImageView iv, String url, int placeId,int emptyImg) {
        if (!TextUtils.isEmpty(url)) {
            GlideApp.with(context)
                    .load(url)
                    .error(emptyImg)
                    .placeholder(placeId)
                    .transform(new RoundedCornersTransformation(10,5))
                    .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .into(iv);
        } else {
            loadImage(context, iv, emptyImg, emptyImg);
        }
    }


    /**
     * 加载高斯模糊图片
     * @param context  context
     * @param iv       imageView
     * @param url      图片地址
     * @param emptyImg 默认展位图
     */
    public static void loadBlur(Context context, ImageView iv, String url, int placeId,int emptyImg) {
        if (!TextUtils.isEmpty(url)) {
            GlideApp.with(context)
                    .load(url)
                    .error(emptyImg)
                    .placeholder(placeId)
                    .transform(new BlurTransformation())
                    .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .into(iv);
        } else {
            loadImage(context, iv, emptyImg, emptyImg);
        }
    }


    /**
     * 加载本地图片资源
     *
     * @param context  context
     * @param iv       imageView
     * @param resId
     * @param emptyImg 默认占位图
     */
    public static void loadImage(Context context, ImageView iv, int resId, int emptyImg) {
        GlideApp.with(context)
                .load(resId)
                .placeholder(emptyImg)
                .dontTransform()
                .into(iv);

    }




















}
