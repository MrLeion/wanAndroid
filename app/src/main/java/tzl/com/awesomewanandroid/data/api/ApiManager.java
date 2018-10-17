package tzl.com.awesomewanandroid.data.api;

import tzl.com.awesomewanandroid.BuildConfig;
import tzl.com.awesomewanandroid.core.net.WHttpClient;

/**
 * author: tangzenglei
 * created on: 2018/8/14 下午1:54
 * description: 获取 client
 */
public class ApiManager {

    private static class ApiHolder{
        private static Api api = WHttpClient.getObservables(BuildConfig.BASE_URL, Api.class);
    }

    private static class VideoHolder{
        private static VideoApi videoApi = WHttpClient.getObservables(BuildConfig.BASE_VIDEO_URL, VideoApi.class);
    }

    private static class NeteaseHolder{
        private static NeteaseApi neteaseApi = WHttpClient.getObservables(BuildConfig.BASE_NETEASE_URL, NeteaseApi.class);
    }

    private static class NewsHolder{
        private static NewsApi newsApi = WHttpClient.getObservables(BuildConfig.BASE_NEWS_URL, NewsApi.class);
    }

    public static Api getWanAndroidApi(){
        return ApiHolder.api;
    }


    public static VideoApi getVideoApi(){
        return VideoHolder.videoApi;
    }


    public static NewsApi getNewsApi(){
        return NewsHolder.newsApi;
    }

























}
