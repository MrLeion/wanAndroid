package tzl.com.awesomewanandroid.ui.news.detail;

import java.util.List;

import io.reactivex.Observable;
import tzl.com.awesomewanandroid.data.api.ApiManager;
import tzl.com.awesomewanandroid.data.pojo.BaseReadHubResponse;
import tzl.com.awesomewanandroid.data.pojo.Topic;
import tzl.com.framework.base.BaseModel;

/**
 * author: tangzenglei
 * created on: 2018/9/5 下午2:31
 * description:
 */
public class NewsDetailModel extends BaseModel{



    public Observable<BaseReadHubResponse<List<Topic>>> getTopic(int pageSize, String lastCursor) {
        return ApiManager.getNewsApi().getTopic(pageSize,lastCursor);
    }



}
