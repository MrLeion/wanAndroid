package tzl.com.framework.net;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLSocketFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import tzl.com.framework.helper.HttpsSupport;
import tzl.com.framework.net.interceptor.ReadCookiesInterceptor;
import tzl.com.framework.net.interceptor.SaveCookiesInterceptor;

/**
 * author: tangzenglei
 * created on: 2018/7/27 下午8:50
 * description:support https by trust all
 */
public class NoCerOkHttpClient {


    private static final long TIME_OUT = 10L;
    public static OkHttpClient getUnsafeOkHttpClient(InputStream[] certificates) {
        SSLSocketFactory sslSocketFactory = HttpsSupport.getSslSocketFactory(certificates, null, null);
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder = builder.sslSocketFactory(sslSocketFactory);
        builder.hostnameVerifier(new HttpsSupport.UnSafeHostnameVerifier())
                //方案一
//                .cookieJar(new CookieManger(ContextHolder.getContext()))
                //方案二
                .addInterceptor(new ReadCookiesInterceptor())
                .addInterceptor(new SaveCookiesInterceptor())
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

        //生产环境去除代理
//        if (BuildConfig.DEBUG) {
//            builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//        }else{
//            builder.proxy(Proxy.NO_PROXY);
//        }
        return builder.build();
    }

}
