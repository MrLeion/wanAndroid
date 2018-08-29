package tzl.com.awesomewanandroid.ui.project;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;
import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.adapter.ProjectListAdapter;
import tzl.com.awesomewanandroid.base.WBaseLazyFragment;
import tzl.com.awesomewanandroid.data.api.ApiManager;
import tzl.com.awesomewanandroid.data.pojo.ProjectList;
import tzl.com.framework.data.AppConfig;
import tzl.com.framework.net.pojo.BaseResponse;
import tzl.com.framework.rx.BaseObserver;
import tzl.com.framework.rx.RxSchedulers;
import tzl.com.framework.widget.multistatusview.MultipleStatusView;

/**
 * author: tangzenglei
 * created on: 2018/8/27 下午4:00
 * description:列表
 */
public class ProjectFragment extends WBaseLazyFragment {


    @BindView(R.id.recyclerView)
    RecyclerView       mRecyclerView;
    @BindView(R.id.multistatusview)
    MultipleStatusView mMultistatusview;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private ProjectListAdapter mProjectListAdapter;
    private int                mCid;


    public static ProjectFragment newInstance(int cid) {
        ProjectFragment projectFragment = new ProjectFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(AppConfig.PROJECT_ID, cid);
        projectFragment.setArguments(bundle);
        return projectFragment;
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_project;
    }

    @Override
    public void initView() {
        Bundle bundle = getArguments();
        mProjectListAdapter = new ProjectListAdapter(R.layout.item_project_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mCid = bundle.getInt(AppConfig.PROJECT_ID);
    }

    private void loadData() {
        ApiManager.getApi().getProjects(1, mCid)
                .compose(RxSchedulers.<BaseResponse<ProjectList>>applyObservableAsync())
                .subscribe(new BaseObserver<ProjectList>() {

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

    @Override
    public void initEvent() {
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                loadData();
            }
        });
    }

    @Override
    public void initData() {

    }


    @Override
    protected void onLazyLoad() {
        loadData();
    }
}
