package tzl.com.awesomewanandroid.data.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import tzl.com.awesomewanandroid.data.pojo.HomeVideo;
import tzl.com.framework.net.pojo.BaseResponse;

/**
 * author: tangzenglei
 * created on: 2018/10/10 下午4:18
 * description:
 */
public interface NeteaseApi {



    @GET("/top/playlist")
    Observable<BaseResponse<HomeVideo>> getTopPlayList();



}
