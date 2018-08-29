package tzl.com.awesomewanandroid.ui.project;

import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.base.WBaseFragmentPagerAdapter;
import tzl.com.awesomewanandroid.base.WBaseFragment;
import tzl.com.awesomewanandroid.data.api.ApiManager;
import tzl.com.awesomewanandroid.data.pojo.ProjectTree;
import tzl.com.framework.net.pojo.BaseResponse;
import tzl.com.framework.rx.BaseObserver;
import tzl.com.framework.rx.RxSchedulers;
import tzl.com.framework.widget.multistatusview.MultipleStatusView;

/**
 * author: tangzenglei
 * created on: 2018/8/27 下午4:00
 * description:体系
 */
public class ProjectListFragment extends WBaseFragment {


    @BindView(R.id.stlProject)
    SlidingTabLayout   mStlProject;
    @BindView(R.id.viewPager)
    ViewPager          mViewPager;
    @BindView(R.id.multistatusview)
    MultipleStatusView mMultistatusview;
    Unbinder unbinder;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_project_list;
    }

    @Override
    public void initView() {
        ApiManager.getApi().getProjectTree()
                .compose(RxSchedulers.<BaseResponse<List<ProjectTree>>>applyObservableAsync())
                .subscribe(new BaseObserver<List<ProjectTree>>(mActivity, true) {

                    @Override
                    public void onSuccess(BaseResponse<List<ProjectTree>> response) {
                        if (response.getData() != null) {
                            ArrayList<WBaseFragment> wBaseFragments = new ArrayList<>();
                            ArrayList<String> titles = new ArrayList<>();
                            List<ProjectTree> data = response.getData();
                            for (int i = 0; i < data.size(); i++) {
                                ProjectTree projectTree = data.get(i);
                                wBaseFragments.add(ProjectFragment.newInstance(projectTree.getId()));
                                titles.add(projectTree.getName());
                            }
                            WBaseFragmentPagerAdapter adapter = new WBaseFragmentPagerAdapter(mActivity.getSupportFragmentManager(), wBaseFragments, titles);
                            mViewPager.setAdapter(adapter);
                            mStlProject.setViewPager(mViewPager);
                        }
                    }

                    @Override
                    public void onFailure(BaseResponse<List<ProjectTree>> response) {

                    }
                });

    }

    @Override
    public void initEvent() {


    }

    @Override
    public void initData() {

    }

}
