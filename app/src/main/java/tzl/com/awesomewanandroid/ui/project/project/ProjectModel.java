package tzl.com.awesomewanandroid.ui.project.project;

import io.reactivex.Observable;
import tzl.com.awesomewanandroid.data.api.ApiManager;
import tzl.com.awesomewanandroid.data.pojo.ProjectList;
import tzl.com.framework.base.BaseModel;
import tzl.com.framework.net.pojo.BaseResponse;

/**
 * author: tangzenglei
 * created on: 2018/9/5 下午1:40
 * description:
 */
public class ProjectModel extends BaseModel {


    Observable<BaseResponse<ProjectList>> getProjects(int pageNo, int cid) {
        return  ApiManager.getWanAndroidApi().getProjects(pageNo, cid);
    }


}
