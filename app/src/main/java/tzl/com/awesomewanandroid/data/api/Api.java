package tzl.com.awesomewanandroid.data.api;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import tzl.com.awesomewanandroid.data.pojo.ArticleList;
import tzl.com.awesomewanandroid.data.pojo.Banner;
import tzl.com.awesomewanandroid.data.pojo.Friend;
import tzl.com.awesomewanandroid.data.pojo.HotKey;
import tzl.com.awesomewanandroid.data.pojo.ProjectList;
import tzl.com.awesomewanandroid.data.pojo.ProjectTree;
import tzl.com.framework.net.pojo.BaseResponse;

/**
 * author: tangzenglei
 * created on: 2018/7/31 下午4:25
 * description:
 */
public interface Api {


    /***
     * 首页文章列表
     * @param index
     * @return
     */
    @GET("/article/list/{index}/json")
    Observable<BaseResponse<ArticleList>> getAricle(@Path("index") int index);


    /***
     * 首页banner
     * @return
     */
    @GET("/banner/json")
    Observable<BaseResponse<Banner>> getBanner();

    /***
     * 常用网站
     * @return
     */
    @GET("/friend/json")
    Observable<BaseResponse<Friend>> getFriend();

    /***
     * 搜索热词
     * @return
     */
    @GET("/hotkey/json")
    Observable<BaseResponse<HotKey>> getHotkey();


    /***
     * 项目分类
     * @return
     */
    @GET("/project/tree/json")
    Observable<BaseResponse<List<ProjectTree>>> getProjectTree();


    /***
     * 项目列表
     * @return
     */
    @GET("/project/list/{pageNo}/json")
    Observable<BaseResponse<ProjectList>> getProjects(@Path("pageNo")int pageNo, @Query("cid") int cid);






    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("/user/login")
    Observable<BaseResponse<Object>> login(@Field("username") String username,@Field("password") String password);
















}
