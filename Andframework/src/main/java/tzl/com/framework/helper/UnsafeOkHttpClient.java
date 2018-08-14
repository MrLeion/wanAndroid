package tzl.com.framework.helper;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLSocketFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * author: tangzenglei
 * created on: 2018/7/27 下午8:50
 * description:support https by trust all
 */
public class UnsafeOkHttpClient {
    private static final long TIME_OUT = 10L;
    public static OkHttpClient getUnsafeOkHttpClient(InputStream... certificates) {
        SSLSocketFactory sslSocketFactory = HttpsSupport.getSslSocketFactory(certificates, null, null);
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder = builder.sslSocketFactory(sslSocketFactory);
        builder.hostnameVerifier(new HttpsSupport.UnSafeHostnameVerifier())
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)) ;
        return builder.build();
    }

}
