package tzl.com.awesomewanandroid.ui.project;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.base.WBaseFragment;
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
public class ProjectFragment extends WBaseFragment {


    @BindView(R.id.recyclerView)
    RecyclerView       mRecyclerView;
    @BindView(R.id.multistatusview)
    MultipleStatusView mMultistatusview;



    public static ProjectFragment newInstance(int cid) {
        ProjectFragment projectFragment = new ProjectFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(AppConfig.PROJECT_ID,cid);
        projectFragment.setArguments(bundle);
        return  projectFragment;
    }



    @Override
    public int getLayoutId() {
        return R.layout.fragment_project;
    }

    @Override
    public void initView() {
        Bundle bundle = getArguments();
        int cid = bundle.getInt(AppConfig.PROJECT_ID);
        ApiManager.getApi().getProjects(1,cid)
                .compose(RxSchedulers.<BaseResponse<ProjectList>>applyObservableAsync())
                .subscribe(new BaseObserver<ProjectList>() {

                    @Override
                    public void onSuccess(BaseResponse<ProjectList> response) {
                        if (response.getData() != null) {
//                            mRecyclerView.setAdapter();
                        }
                    }

                    @Override
                    public void onFailure(BaseResponse<ProjectList> response) {

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
