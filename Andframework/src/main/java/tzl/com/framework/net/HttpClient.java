package tzl.com.framework.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author: tangzenglei
 * created on: 2018/7/31 下午3:11
 * description: 网络请求
 */
public class HttpClient {

       public static Retrofit.Builder mRetrofitBuilder = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(getHttpClient().newBuilder()
                    //                    .addInterceptor(new GlobalNetworkInterceptor(App.getContext()))
                    .build());

    public static OkHttpClient getHttpClient() {
        return HttpClientHolder.httpClient;
    }

    private static class HttpClientHolder {
        private static OkHttpClient httpClient = getHttpClient();
        private static OkHttpClient getHttpClient() {
            return NoCerOkHttpClient.getUnsafeOkHttpClient(null);
        }
    }


    public static <T> T getObservables(final String baseUrl, final Class<T> service) {
        return mRetrofitBuilder.baseUrl(baseUrl).build().create(service);
    }


}
