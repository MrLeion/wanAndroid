package tzl.com.awesomewanandroid.ui.news;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.adapter.NewsAdapter;
import tzl.com.awesomewanandroid.data.pojo.BaseReadHubObserver;
import tzl.com.awesomewanandroid.data.pojo.BaseReadHubResponse;
import tzl.com.awesomewanandroid.data.pojo.Topic;
import tzl.com.framework.base.BasePresenter;
import tzl.com.framework.rx.RxSchedulers;
import tzl.com.framework.widget.multistatusview.MultipleStatusView;
import tzl.com.framework.widget.recyclerView.layoutManager.OverLayCardLayoutManager;
import tzl.com.framework.widget.recyclerView.layoutManager.OverlayCallback;

/**
 * author: tangzenglei
 * created on: 2018/9/5 下午2:30
 * description:
 */
public class NewsPresenter extends BasePresenter<NewsView,NewsModel> {

    private MultipleStatusView mMultistatusview;
    private RecyclerView mRecyclerView;
    private NewsAdapter mNewsAdapter;

    /**
     * 绑定 View 和 model
     *
     * @param view
     * @param model
     */
    public NewsPresenter(NewsView view, NewsModel model) {
        super(view, model);
    }

    @Override
    public void init() {
        mMultistatusview = mView.getMultistatusview();
        mRecyclerView = mView.getRecyclerView();
        setUpReclerView();

    }

    private void setUpReclerView() {
        mRecyclerView.setLayoutManager(new OverLayCardLayoutManager(mActivity));
        mNewsAdapter = new NewsAdapter(R.layout.item_news_card);
        mRecyclerView.setAdapter(mNewsAdapter);
        mNewsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                if () {
//                }
            }
        });
    }

    @Override
    public void registerEvent() {

    }

    public void loadData() {


        mModel.getTopic(20, "")
                .compose(RxSchedulers.<BaseReadHubResponse<List<Topic>>>applyObservableAsync())
                .subscribe(new BaseReadHubObserver<List<Topic>>() {
                    @Override
                    public void onSuccess(BaseReadHubResponse<List<Topic>> response) {

                        if (response!=null&&response.getData()!=null) {
                            mMultistatusview.showContent();
                            OverlayCallback overlayCallback = new OverlayCallback(mRecyclerView, mNewsAdapter, response.getData());
                            ItemTouchHelper itemTouchHelper = new ItemTouchHelper(overlayCallback);
                            itemTouchHelper.attachToRecyclerView(mRecyclerView);
                            mNewsAdapter.setNewData(response.getData());
                        }else{
                            mMultistatusview.showEmpty();

                        }

                    }

                    @Override
                    public void onFailure(BaseReadHubResponse<List<Topic>> response) {
                        mMultistatusview.showEmpty();
//                        ToastHelper.showToast(response.toString());
                    }
                });







    }
}
