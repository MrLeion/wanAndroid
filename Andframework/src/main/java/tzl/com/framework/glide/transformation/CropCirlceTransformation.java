package tzl.com.framework.glide.transformation;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.bumptech.glide.BuildConfig;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;

import java.security.MessageDigest;

/**
 * author: tangzenglei
 * created on: 2018/7/27 下午4:40
 * description:圆形头像
 * https://github.com/wasabeef/glide-transformations
 */
public class CropCirlceTransformation extends BitmapTransformation {
    private static final int VERSION = BuildConfig.VERSION_CODE;
    private static final String ID =
            "tzl.com.framework.glide.transformation.CropCirlceTransformation." + VERSION;

    @Override public String toString() {
        return "CropCircleTransformation()";
    }

    @Override public boolean equals(Object o) {
        return o instanceof CropCirlceTransformation;
    }

    @Override public int hashCode() {
        return ID.hashCode();
    }

    @Override public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((ID).getBytes(CHARSET));
    }

    @Override
    protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        return TransformationUtils.circleCrop(pool, toTransform, outWidth, outHeight);
    }
}
