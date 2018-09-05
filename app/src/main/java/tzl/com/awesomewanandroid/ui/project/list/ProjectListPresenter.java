package tzl.com.awesomewanandroid.ui.project.list;

import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;
import tzl.com.awesomewanandroid.base.WBaseFragment;
import tzl.com.awesomewanandroid.base.WBaseFragmentPagerAdapter;
import tzl.com.awesomewanandroid.data.pojo.ProjectTree;
import tzl.com.awesomewanandroid.event.ProjectListEvent;
import tzl.com.awesomewanandroid.ui.project.project.ProjectFragment;
import tzl.com.framework.base.BasePresenter;
import tzl.com.framework.net.pojo.BaseResponse;
import tzl.com.framework.rx.BaseObserver;
import tzl.com.framework.rx.RxBus;
import tzl.com.framework.rx.RxSchedulers;
import tzl.com.framework.widget.multistatusview.MultipleStatusView;

/**
 * author: tangzenglei
 * created on: 2018/9/5 上午10:43
 * description:
 */
public class ProjectListPresenter extends BasePresenter<ProjectListView,ProjectListModel>{

    private  MultipleStatusView mMultistatusview;
    private  SlidingTabLayout mStlProject;
    private  ViewPager mViewPager;

    /**
     * 绑定 View 和 model
     * @param view
     * @param model
     */
    public ProjectListPresenter(ProjectListView view, ProjectListModel model) {
        super(view, model);
    }

    @Override
    public void init() {
        mMultistatusview = mView.getMultistatusview();
        mStlProject = mView.getStlProject();
        mViewPager = mView.getViewPager();
    }

    @Override
    public void registerEvent() {
        RxBus.getDefault().toObservable(ProjectListEvent.class)
                .subscribe(new Consumer<ProjectListEvent>() {
                    @Override
                    public void accept(ProjectListEvent projectListEvent) throws Exception {
                        loadData();
                    }
                });
    }


    public void loadData() {
        mModel.getProjectTree()
                .compose(RxSchedulers.<BaseResponse<List<ProjectTree>>>applyObservableAsync())
                .subscribe(new BaseObserver<List<ProjectTree>>(mActivity, true) {

                    @Override
                    public void onSuccess(BaseResponse<List<ProjectTree>> response) {
                        if (response.getData() != null) {
                            mMultistatusview.showContent();
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
                        }else{
                            mMultistatusview.showEmpty();
                        }
                    }

                    @Override
                    public void onFailure(BaseResponse<List<ProjectTree>> response) {
                            mMultistatusview.showEmpty();
                    }

                });

    }
}
