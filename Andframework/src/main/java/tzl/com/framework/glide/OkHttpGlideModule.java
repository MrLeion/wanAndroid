package tzl.com.framework.glide;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;

import java.io.InputStream;
import java.net.HttpURLConnection;

import tzl.com.framework.glide.support.UnSafeOkHttpUrlLoader;

/**
 * author: tangzenglei
 * created on: 2018/7/26 下午5:37
 * description: normal config glide ImageLoader fetching stream over OkHttp3
 */
@GlideModule
public class OkHttpGlideModule extends AppGlideModule {


    public static final int MAX_SIZE = 10 * 1000 * 1000;

    /**
     * @Author tangzenglei
     * Config glide by these ways:
     * {@link com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool}
     * {@link ArrayPool}
     * {@link com.bumptech.glide.load.engine.Engine}
     * and so on, objects in {@link GlideBuilder}
     * @param context
     * @param builder
     */
    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {


        //avoid image loader slowly
        builder.setDefaultRequestOptions(new RequestOptions()
                                            .format(DecodeFormat.PREFER_RGB_565)
                                            .disallowHardwareConfig()
        );

        //limit the memory size to 10M
        builder.setMemoryCache(new LruResourceCache(MAX_SIZE));


    }


    /**
     * change network dataLoader from {@link HttpURLConnection} to okHttp
     * @param context
     * @param glide
     * @param registry
     */
    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        registry.replace(GlideUrl.class, InputStream.class, new UnSafeOkHttpUrlLoader.Factory());
    }


    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }



}
