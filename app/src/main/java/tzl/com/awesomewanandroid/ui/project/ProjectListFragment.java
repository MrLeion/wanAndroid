package tzl.com.awesomewanandroid.ui.project;

import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;

import butterknife.BindView;
import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.base.XBaseFragment;
import tzl.com.awesomewanandroid.event.ProjectListEvent;
import tzl.com.framework.rx.RxBus;
import tzl.com.framework.widget.multistatusview.MultipleStatusView;

/**
 * author: tangzenglei
 * created on: 2018/8/27 下午4:00
 * description:体系
 */
public class ProjectListFragment extends XBaseFragment<ProjectListPresenter> implements ProjectListView {


    @BindView(R.id.stlProject)
    SlidingTabLayout   mStlProject;
    @BindView(R.id.viewPager)
    ViewPager          mViewPager;
    @BindView(R.id.multistatusview)
    MultipleStatusView mMultistatusview;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_project_list;
    }

    @Override
    public void initView() {


    }

    @Override
    public void initEvent() {


    }

    @Override
    public void initData() {
        mPresenter = new ProjectListPresenter(this, new ProjectListModel());
        RxBus.getDefault().post(new ProjectListEvent());
    }

    public SlidingTabLayout getStlProject() {
        return mStlProject;
    }

    public ViewPager getViewPager() {
        return mViewPager;
    }

    public MultipleStatusView getMultistatusview() {
        return mMultistatusview;
    }
}
