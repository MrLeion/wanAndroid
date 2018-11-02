package tzl.com.awesomewanandroid.ui.search;

import io.reactivex.Observable;
import tzl.com.awesomewanandroid.data.api.ApiManager;
import tzl.com.framework.base.BaseModel;
import tzl.com.framework.net.pojo.BaseResponse;

/**
 * author: tangzenglei
 * created on: 2018/9/5 下午2:31
 * description:
 */
public class SearchModel extends BaseModel{



    public Observable<BaseResponse<Object>> query(int pageNo, String key) {
        return ApiManager.getWanAndroidApi().query(pageNo, key);
    }




}
