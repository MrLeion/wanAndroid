package tzl.com.awesomewanandroid.ui.project.project;

import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.adapter.ProjectListAdapter;
import tzl.com.awesomewanandroid.data.pojo.ProjectList;
import tzl.com.framework.base.BasePresenter;
import tzl.com.framework.net.pojo.BaseResponse;
import tzl.com.framework.rx.BaseObserver;
import tzl.com.framework.rx.RxSchedulers;
import tzl.com.framework.widget.multistatusview.MultipleStatusView;

/**
 * author: tangzenglei
 * created on: 2018/9/5 下午1:40
 * description:
 */
public class ProjectPresenter extends BasePresenter<ProjectView,ProjectModel>{


    private ProjectListAdapter mProjectListAdapter;
    private MultipleStatusView mMultistatusview;
    private RecyclerView mRecyclerView;
    private SmartRefreshLayout mRefreshLayout;


    /**
     * 绑定 View 和 model
     *
     * @param view
     * @param model
     */
    public ProjectPresenter(ProjectView view, ProjectModel model) {
        super(view, model);
        init();
    }

    public void init() {
        mProjectListAdapter = new ProjectListAdapter(R.layout.item_project_list);
        mMultistatusview = mView.getMultistatusview();
        mRecyclerView = mView.getRecyclerView();
        mRefreshLayout = mView.getRefreshLayout();
    }

    @Override
    public void registerEvent() {

    }

    public void loadData(int cid) {
        mModel.getProjects(1, cid)
                .compose(RxSchedulers.<BaseResponse<ProjectList>>applyObservableAsync())
                .subscribe(new BaseObserver<ProjectList>(mActivity,true) {

                    @Override
                    public void onSuccess(BaseResponse<ProjectList> response) {
                        mRefreshLayout.finishRefresh();
                        mMultistatusview.showContent();
                        if (response.getData() != null) {
                            List<ProjectList.DatasBean> datas = response.getData().getDatas();
                            if (datas != null && datas.size() > 0) {
                                mProjectListAdapter.setNewData(datas);
                                mRecyclerView.setAdapter(mProjectListAdapter);
                            } else {
                                mMultistatusview.showEmpty();
                            }
                        }
                    }

                    @Override
                    public void onFailure(BaseResponse<ProjectList> response) {
                        mRefreshLayout.finishRefresh();
                        mMultistatusview.showError();
                    }
                });

    }
}
