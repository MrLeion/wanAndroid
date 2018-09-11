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
import tzl.com.awesomewanandroid.data.pojo.CollectionActicle;
import tzl.com.awesomewanandroid.data.pojo.Friend;
import tzl.com.awesomewanandroid.data.pojo.HotKey;
import tzl.com.awesomewanandroid.data.pojo.NaviJson;
import tzl.com.awesomewanandroid.data.pojo.ProjectList;
import tzl.com.awesomewanandroid.data.pojo.ProjectTree;
import tzl.com.awesomewanandroid.data.pojo.Tree;
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
    Observable<BaseResponse<List<Banner>>> getBanner();

    /***
     * 常用网站  --- 显示于搜索框下方
     * @return
     */
    @GET("/friend/json")
    Observable<BaseResponse<Friend>> getFriend();

    /***
     * 搜索热词 --- 联想搜索
     * @return
     */
    @GET("/hotkey/json")
    Observable<BaseResponse<HotKey>> getHotkey();

    /**
     * =======================知识体系 =======================
     */

    /***
     * 体系数据
     * @return
     */
    @GET("/tree/json")
    Observable<BaseResponse<Tree>> getTree();



    /***
     * 某个知识体系下的文章
     * @return
     */
    @GET("/article/list/{index}/json")
    Observable<BaseResponse<Tree>> getTreeArticles(@Query("cid")int cid,@Path("index")int index);




    /**
     * 搜索
     * @return
     */
    @FormUrlEncoded
    @POST("/article/query/{index}/json")
    Observable<BaseResponse<Object>> query(@Path("index") String index,@Field("K") String key);




    /**
     * =======================导航 =======================
     */


    /***
     * 导航数据
     * @return
     */
    @GET("/navi/json")
    Observable<BaseResponse<NaviJson>> getNaviJson();




    /***
     * 项目分类
     * @return
     */
    @GET("/project/tree/json")
    Observable<BaseResponse<List<ProjectTree>>> getProjectTree();


    /***
     * 某一个分类下项目列表数据
     * @return
     */
    @GET("/project/list/{pageNo}/json")
    Observable<BaseResponse<ProjectList>> getProjects(@Path("pageNo")int pageNo, @Query("cid") int cid);








    /**
     * =======================用户中心=======================
     */

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("/user/login")
    Observable<BaseResponse<Object>> login(@Field("username") String username,@Field("password") String password);



    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("/user/register")
    Observable<BaseResponse<Object>> register(@Field("username") String username,@Field("password") String password,@Field("repassword") String repassword);



    /***
     * 退出登录
     * @return
     */
    @GET("/user/logout/json")
    Observable<BaseResponse<Object>> logout();






    /**
     * ======================= 收藏操作 =======================
     */

    /***
     * 收藏文章列表
     * @return
     */
    @GET("/lg/collect/list/{index}/json")
    Observable<BaseResponse<CollectionActicle>> getCollectArticles(@Path("index")int index);


    /**
     * 收藏站内文章
     * @return
     */
    @FormUrlEncoded
    @POST("/lg/collect/{cid}/json")
    Observable<BaseResponse<Object>> CollectInternal(@Path("cid") int cid);


    /**
     * 收藏站外文章
     * @return
     */
    @FormUrlEncoded
    @POST("/lg/collect/add/json")
    Observable<BaseResponse<Object>> CollectExternal(@Field("title") String title,
                                                     @Field("link") String link,
                                                     @Field("author") String author);






    /**
     * 取消收藏
     * @return
     */
    @FormUrlEncoded
    @POST("/lg/uncollect_originId/{id}/json")
    Observable<BaseResponse<Object>> unCollect(@Field("id") int id);







    /***
     * 收藏网站列表
     * @return
     */
    @GET("/lg/collect/usertools/json")
    Observable<BaseResponse<CollectionActicle>> getUserTools();





    /**
     * 收藏网址
     * @return
     */
    @FormUrlEncoded
    @POST("/lg/collect/addtool/json")
    Observable<BaseResponse<Object>> addTool(@Field("name") String name,@Field("link") String link);



    /**
     * 删除收藏网站
     * @return
     */
    @FormUrlEncoded
    @POST("/lg/collect/deletetool/json")
    Observable<BaseResponse<Object>> deleteTool(@Field("id") int id);






    /**
     * ======================= 事务清单 =======================
     */

    /**
     *新增一条Todo
     * @return
     */
    @FormUrlEncoded
    @POST("/lg/todo/add/json")
    Observable<BaseResponse<Object>> addTodo(@Field("title") String title,
                                             @Field("content") String content,
                                             @Field("date") String date,
                                             @Field("type") int type);


    /**
     *更新一条Todo内容
     * @return
     */
    @FormUrlEncoded
    @POST("/lg/todo/update/{id}/json")
    Observable<BaseResponse<Object>> updateTodo(@Field("id")int id,
                                                @Field("title") String title,
                                                @Field("content") String content,
                                                @Field("date") String date,
                                                @Field("status") int status,
                                                @Field("type") int type);




    /**
     * 删除一条Todo
     * @return
     */
    @FormUrlEncoded
    @POST("/lg/todo/delete/{id}/json")
    Observable<BaseResponse<Object>> deleteTodo(@Field("id") int id);





    /**
     * 仅更新完成状态Todo
     * @return
     */
    @FormUrlEncoded
    @POST("/lg/todo/done/{id}/json")
    Observable<BaseResponse<Object>> updateStatus(@Field("id") int id,@Field("status") int status);


    /**
     * 未完成 Todo 列表
     * @return
     */
    @FormUrlEncoded
    @POST("/lg/todo/listnotdo/{type}/json/{index}")
    Observable<BaseResponse<Object>> getListNoTodo(@Field("index") int index,@Field("type") int type);


    /**
     * 已完成 Todo 列表
     * @return
     */
    @FormUrlEncoded
    @POST("/lg/todo/listdone/{type}/json/{index}")
    Observable<BaseResponse<Object>> getListDone(@Field("index") int index,@Field("type") int type);



























}
