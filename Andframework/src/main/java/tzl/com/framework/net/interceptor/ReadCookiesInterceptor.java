package tzl.com.framework.net.interceptor;

import android.util.Log;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Request;
import okhttp3.Response;
import tzl.com.framework.cache.CacheManager;
import tzl.com.framework.data.AppConfig;

/**
 * author: tangzenglei
 * created on: 2018/8/21 下午5:57
 * description: 将保存的 cookies 加入 请求头
 */
public class ReadCookiesInterceptor extends BaseInterceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        HashSet<String> cookies = (HashSet) CacheManager.getObject(AppConfig.PRE_COOKIE);
        for (String cookie : cookies) {
            builder.addHeader("Cookie", cookie);
            Log.v("OkHttp", "Adding Header: " + cookie); // This is done so I know which headers are being added; this interceptor is used after the normal logging of OkHttp
        }
        return chain.proceed(builder.build());
    }
}
