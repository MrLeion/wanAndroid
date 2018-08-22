package tzl.com.framework.net.interceptor;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Response;
import tzl.com.framework.cache.CacheManager;
import tzl.com.framework.data.AppConfig;

/**
 * author: tangzenglei
 * created on: 2018/8/21 下午6:01
 * description: 保存 cookies 至本地
 */
public class SaveCookiesInterceptor extends BaseInterceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>();
            for (String header : originalResponse.headers("Set-Cookie")) {
                cookies.add(header);
            }
            CacheManager.putObject(AppConfig.PRE_COOKIE, cookies);
        }

        return originalResponse;
    }
}
