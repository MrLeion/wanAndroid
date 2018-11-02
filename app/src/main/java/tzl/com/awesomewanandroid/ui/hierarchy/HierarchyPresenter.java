package tzl.com.awesomewanandroid.ui.hierarchy;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.adapter.HierarchyAdapter;
import tzl.com.awesomewanandroid.data.pojo.ProjectTree;
import tzl.com.framework.base.BasePresenter;
import tzl.com.framework.net.pojo.BaseResponse;
import tzl.com.framework.rx.BaseObserver;
import tzl.com.framework.rx.RxSchedulers;
import tzl.com.framework.widget.multistatusview.MultipleStatusView;

/**
 * author: tangzenglei
 * created on: 2018/9/10 上午11:54
 * description:
 */
public class HierarchyPresenter extends BasePresenter<HierarchyView,hierarchyModel> {

    private RecyclerView mRecyclerView;
    private SmartRefreshLayout mRefreshLayout;
    private MultipleStatusView mMultistatusview;
    private HierarchyAdapter mHierarchyAdapter;

    /**
     * 绑定 View 和 model
     * @param view
     * @param model
     */
    public HierarchyPresenter(HierarchyView view, hierarchyModel model) {
        super(view, model);
    }

    @Override
    public void init() {
        mRecyclerView = mView.getRecyclerView();
        mRefreshLayout = mView.getRefreshLayout();
        mMultistatusview = mView.getMultistatusview();
        setRecyclerView();
    }

    @Override
    public void registerEvent() {

        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                loadData();
            }
        });

        mHierarchyAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                
            }
        });
    }


    private void setRecyclerView() {
        mRecyclerView.setLayoutManager(new GridLayoutManager(mActivity,3));
        mRecyclerView.setHasFixedSize(false);
        mHierarchyAdapter = new HierarchyAdapter(R.layout.item_hierarchy,mActivity);
        mRecyclerView.setAdapter(mHierarchyAdapter);
    }

    public void loadData() {
         mModel.getProjectTree()
                         .compose(RxSchedulers.<BaseResponse<List<ProjectTree>>>applyObservableAsync())
                         .subscribe(new BaseObserver<List<ProjectTree>>() {
         
                             @Override
                             public void onSuccess(BaseResponse<List<ProjectTree>> response) {
                                 if (null!=mRefreshLayout&&mRefreshLayout.isRefreshing()) {
                                     mRefreshLayout.finishRefresh();
                                 }

                                 if (response!=null&response.getData() != null) {
                                     mMultistatusview.showContent();
                                     mHierarchyAdapter.setNewData(response.getData());
                                 }else{
                                     mMultistatusview.showEmpty();
                                 }
                             }
         
                             @Override
                             public void onFailure(BaseResponse<List<ProjectTree>> response) {

                                 if (null!=mRefreshLayout&&mRefreshLayout.isRefreshing()) {
                                     mRefreshLayout.finishRefresh();
                                 }

                                 mMultistatusview.showEmpty();
                             }
         
                         });
        
    }
}
