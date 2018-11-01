package tzl.com.awesomewanandroid.ui.navigator;

import java.util.List;

import io.reactivex.Observable;
import tzl.com.awesomewanandroid.data.api.ApiManager;
import tzl.com.awesomewanandroid.data.pojo.NaviJson;
import tzl.com.framework.base.BaseModel;
import tzl.com.framework.net.pojo.BaseResponse;

/**
 * author: tangzenglei
 * created on: 2018/9/5 下午2:31
 * description:
 */
public class NavigatorModel extends BaseModel{


    /***
     * 导航数据
     * @return
     */
    Observable<BaseResponse<List<NaviJson>>> getNaviJson(){
        return ApiManager.getWanAndroidApi().getNaviJson();
    }




}
