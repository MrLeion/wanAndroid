package tzl.com.awesomewanandroid.ui.hierarchy;

import java.util.List;

import io.reactivex.Observable;
import tzl.com.awesomewanandroid.data.api.ApiManager;
import tzl.com.awesomewanandroid.data.pojo.ProjectTree;
import tzl.com.framework.base.BaseModel;
import tzl.com.framework.net.pojo.BaseResponse;

/**
 * author: tangzenglei
 * created on: 2018/9/10 上午11:53
 * description:
 */
public class hierarchyModel extends BaseModel {


    /***
     * 知识体系
     * @return
     */
    Observable<BaseResponse<List<ProjectTree>>> getProjectTree(){
        return ApiManager.getWanAndroidApi().getProjectTree();
    }

}
