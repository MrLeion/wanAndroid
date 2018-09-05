package tzl.com.awesomewanandroid.ui.project.list;

import java.util.List;

import io.reactivex.Observable;
import tzl.com.awesomewanandroid.data.api.ApiManager;
import tzl.com.awesomewanandroid.data.pojo.ProjectList;
import tzl.com.awesomewanandroid.data.pojo.ProjectTree;
import tzl.com.framework.base.BaseModel;
import tzl.com.framework.net.pojo.BaseResponse;

/**
 * author: tangzenglei
 * created on: 2018/9/5 上午10:43
 * description:
 */
public class ProjectListModel extends BaseModel {



     Observable<BaseResponse<ProjectList>> getProjects(int pageNo,int cid) {
        return ApiManager.getWanAndroidApi().getProjects(pageNo, cid);
    }



    /***
     * 项目分类
     * @return
     */
    Observable<BaseResponse<List<ProjectTree>>> getProjectTree(){
        return ApiManager.getWanAndroidApi().getProjectTree();
    }






}
