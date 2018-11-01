package tzl.com.awesomewanandroid.ui.project.project;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.base.WBaseLazyFragment;
import tzl.com.framework.data.AppConfig;
import tzl.com.framework.widget.multistatusview.MultipleStatusView;

/**
 * author: tangzenglei
 * created on: 2018/8/27 下午4:00
 * description:列表
 */
public class ProjectFragment extends WBaseLazyFragment<ProjectPresenter> implements ProjectView {


    @BindView(R.id.recyclerView)
    RecyclerView       mRecyclerView;
    @BindView(R.id.multistatusview)
    MultipleStatusView mMultistatusview;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
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
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mCid = bundle.getInt(AppConfig.PROJECT_ID);
    }


    @Override
    public void initEvent() {
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mPresenter.loadData(mCid);
            }
        });
    }

    @Override
    public void initData() {
        mPresenter = new ProjectPresenter(this, new ProjectModel());
    }

    @Override
    protected void onLazyLoad() {
        mPresenter.loadData(mCid);
    }


    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    public MultipleStatusView getMultistatusview() {
        return mMultistatusview;
    }

    public SmartRefreshLayout getRefreshLayout() {
        return mRefreshLayout;
    }


}
