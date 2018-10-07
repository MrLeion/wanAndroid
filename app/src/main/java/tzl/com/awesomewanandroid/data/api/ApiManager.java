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
        private static VideoApi videoApi = WHttpClient.getObservables(BuildConfig.VIDEO_BASE_URL, VideoApi.class);
    }



    public static Api getWanAndroidApi(){
        return ApiHolder.api;
    }


    public static VideoApi getVideoApi(){
        return VideoHolder.videoApi;
    }
























}
