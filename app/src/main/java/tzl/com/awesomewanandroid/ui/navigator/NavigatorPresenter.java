package tzl.com.awesomewanandroid.ui.navigator;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.adapter.ContentNavigatorAdapter;
import tzl.com.awesomewanandroid.adapter.IndexNavigatorAdapter;
import tzl.com.awesomewanandroid.data.pojo.NaviJson;
import tzl.com.framework.base.BasePresenter;
import tzl.com.framework.net.pojo.BaseResponse;
import tzl.com.framework.rx.BaseObserver;
import tzl.com.framework.rx.RxSchedulers;
import tzl.com.framework.widget.multistatusview.MultipleStatusView;

/**
 * author: tangzenglei
 * created on: 2018/9/5 下午2:30
 * description:
 */
public class NavigatorPresenter extends BasePresenter<NavigatorView, NavigatorModel> {

    private final RecyclerView            mIndexRecyclerView;
    private final RecyclerView            mContentRecyclerView;
    private final MultipleStatusView      mMultistatusview;
    private       ContentNavigatorAdapter mContentNavigatorAdapter;
    private       IndexNavigatorAdapter   mIndexNavigatorAdapter;

    /**
     * 绑定 View 和 model
     *
     * @param view
     * @param model
     */
    public NavigatorPresenter(NavigatorView view, NavigatorModel model) {
        super(view, model);
        mIndexRecyclerView = mView.getIndexRecyclerView();
        mContentRecyclerView = mView.getContentRecyclerView();
        mMultistatusview = mView.getMultistatusview();
        setIndexRecyclerView();
        setContentRecyclerView();
    }

    private void setContentRecyclerView() {
        mContentRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mContentNavigatorAdapter = new ContentNavigatorAdapter(R.layout.item_naviagator_content,mActivity);
        mContentRecyclerView.setAdapter(mContentNavigatorAdapter);
    }

    private void setIndexRecyclerView() {
        mIndexRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mIndexNavigatorAdapter = new IndexNavigatorAdapter(R.layout.item_naviagator_index);
        mIndexRecyclerView.setAdapter(mIndexNavigatorAdapter);
    }

    @Override
    public void init() {

    }

    @Override
    public void registerEvent() {

    }

    public void loadData() {
        mModel.getNaviJson()
                .compose(RxSchedulers.<BaseResponse<List<NaviJson>>>applyObservableAsync())
                .subscribe(new BaseObserver<List<NaviJson>>() {

                    @Override
                    public void onSuccess(BaseResponse<List<NaviJson>> response) {
                        if (response != null && response.getData() != null && response.getData().size() > 0) {
                            mMultistatusview.showContent();
                            mContentNavigatorAdapter.setNewData(response.getData());
                            mIndexNavigatorAdapter.setNewData(response.getData());
                        } else {
                            mMultistatusview.showEmpty();
                        }
                    }

                    @Override
                    public void onFailure(BaseResponse<List<NaviJson>> response) {
                        mMultistatusview.showError();
                    }

                });


    }

}
