package tzl.com.awesomewanandroid.data.api;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import tzl.com.awesomewanandroid.data.pojo.BaseReadHubResponse;
import tzl.com.awesomewanandroid.data.pojo.Topic;
import tzl.com.awesomewanandroid.data.pojo.TopicDetail;

/**
 * author: tangzenglei
 * created on: 2018/10/10 下午4:18
 * description: https://api.readhub.me
 */
public interface NewsApi {


    /**
     * 热门话题列表
     * @param pageSize
     * @param lastCursor
     * @return
     */
    @GET("/topic")
    Observable<BaseReadHubResponse<List<Topic>>> getTopic(@Query("pageSize")int pageSize, @Query("lastCursor")String lastCursor);


    /**
     * 话题详情
     * @param topicId
     * @return
     */
    @GET("/topic/{topicId}")
    Observable<TopicDetail> getTopicDetail(@Path("topicId")String topicId);


//    /**
//     * 科技动态
//     * @param pageSize
//     * @param lastCursor
//     * @return
//     */
//    @GET("/news")
//    Observable<BaseResponse<HomeVideo>> getNews(@Query("pageSize")int pageSize,@Query("lastCursor")int lastCursor);
//
//
//    /**
//     * 开发者资讯
//     * @param pageSize
//     * @param lastCursor
//     * @return
//     */
//    @GET("/technews")
//    Observable<BaseResponse<HomeVideo>> getTechNews(@Query("pageSize")int pageSize,@Query("lastCursor")int lastCursor);
//
//
//    /**
//     * 区块链资讯
//     * @param pageSize
//     * @param lastCursor
//     * @return
//     */
//    @GET("/blockchain")
//    Observable<BaseResponse<HomeVideo>> getBlockChain(@Query("pageSize")int pageSize,@Query("lastCursor")int lastCursor);





}
