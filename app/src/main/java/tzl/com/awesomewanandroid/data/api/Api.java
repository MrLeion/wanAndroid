package tzl.com.awesomewanandroid.data.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import tzl.com.awesomewanandroid.data.pojo.ArticleList;
import tzl.com.framework.net.pojo.BaseResponse;

/**
 * author: tangzenglei
 * created on: 2018/7/31 下午4:25
 * description:
 */
public interface Api {


    @GET("/article/list/{index}/json")
    Observable<BaseResponse<ArticleList>> getAricle(@Path("index") int index);













}
