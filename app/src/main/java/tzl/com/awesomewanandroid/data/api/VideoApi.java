package tzl.com.awesomewanandroid.data.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import tzl.com.awesomewanandroid.data.pojo.HomeVideo;
import tzl.com.framework.net.pojo.BaseResponse;

/**
 * author: tangzenglei
 * created on: 2018/10/1 下午4:57
 * description:开眼视频
 */
public interface VideoApi {



    @GET("/api/v4/tabs/selected")
    Observable<BaseResponse<HomeVideo>> getSelected();










}
