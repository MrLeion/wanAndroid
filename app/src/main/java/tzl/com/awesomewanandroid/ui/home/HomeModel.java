package tzl.com.awesomewanandroid.ui.home;

import java.util.List;

import io.reactivex.Observable;
import tzl.com.awesomewanandroid.data.api.ApiManager;
import tzl.com.awesomewanandroid.data.pojo.ArticleList;
import tzl.com.awesomewanandroid.data.pojo.Banner;
import tzl.com.framework.base.BaseModel;
import tzl.com.framework.net.pojo.BaseResponse;

/**
 * author: tangzenglei
 * created on: 2018/9/6 上午9:32
 * description:
 */
public class HomeModel extends BaseModel {

    /***
     * 首页banner
     * @return
     */
    public  Observable<BaseResponse<List<Banner>>> getBanner() {
        return ApiManager.getWanAndroidApi().getBanner();
    }



    /***
     * 首页文章列表
     * @param index
     * @return
     */
    Observable<BaseResponse<ArticleList>> getAricle( int index) {
        return ApiManager.getWanAndroidApi().getAricle(index);
    }









}
