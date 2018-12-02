package tzl.com.awesomewanandroid.ui.hierarchy;

import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.base.XBaseFragment;
import tzl.com.framework.widget.multistatusview.MultipleStatusView;

/**
 * author: tangzenglei
 * created on: 2018/8/27 下午4:00
 * description:体系
 */
public class HierarchyFragment extends XBaseFragment<HierarchyPresenter> implements HierarchyView {


    @BindView(R.id.recyclerView)
    RecyclerView       mRecyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.multistatusview)
    MultipleStatusView mMultistatusview;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_hierarchy;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initData() {
        mPresenter = new HierarchyPresenter(this, new hierarchyModel());
        mPresenter.loadData();
    }


    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    public SmartRefreshLayout getRefreshLayout() {
        return mRefreshLayout;
    }

    public MultipleStatusView getMultistatusview() {
        return mMultistatusview;
    }
}
