package tzl.com.awesomewanandroid.ui.news.detail;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.adapter.NewsDetailAdapter;
import tzl.com.awesomewanandroid.data.pojo.TopicDetail;
import tzl.com.awesomewanandroid.ui.h5.JumpUtils;
import tzl.com.framework.base.BasePresenter;
import tzl.com.framework.helper.ToastHelper;
import tzl.com.framework.rx.RxSchedulers;
import tzl.com.framework.widget.recyclerView.decoration.ItemDecoration;

/**
 * author: tangzenglei
 * created on: 2018/9/5 下午2:30
 * description:
 */
public class NewsDetailPresenter extends BasePresenter<NewsDetailView,NewsDetailModel> {

    private RecyclerView mRecyclerView;
    private TextView mTvCommonToolbarTitle;
    private TextView mTvTitle;
    private TextView mTvTime;
    private TextView mTvSummary;
    private NewsDetailAdapter mNewsDetailAdapter;

    /**
     * 绑定 View 和 model
     *
     * @param view
     * @param model
     */
    public NewsDetailPresenter(NewsDetailView view, NewsDetailModel model) {
        super(view, model);
    }

    @Override
    public void init() {
        mTvTitle = mView.getTvTitle();
        mTvTime = mView.getTvTime();
        mTvSummary = mView.getTvSummary();
        mRecyclerView = mView.getRecyclerView();
        setUpReclerView();
    }

    private void setUpReclerView() {
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.addItemDecoration(new ItemDecoration(mActivity, 100));
        mNewsDetailAdapter = new NewsDetailAdapter(R.layout.item_news_timeline);
        mRecyclerView.setAdapter(mNewsDetailAdapter);
    }

    @Override
    public void registerEvent() {
        mNewsDetailAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                TopicDetail.NewsArrayBean arrayBean= (TopicDetail.NewsArrayBean) adapter.getItem(position);
                JumpUtils.startH5(mActivity, arrayBean.getUrl());
            }
        });
    }

    public void loadData(String topicId) {
        mModel.getTopicDetail(topicId)
                .compose(RxSchedulers.<TopicDetail>applyObservableAsync())
                .subscribe(new Observer<TopicDetail>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mActivity.showLoading();
                    }

                    @Override
                    public void onNext(TopicDetail topicDetail) {
                                    if (null!=topicDetail) {
                                        if (!TextUtils.isEmpty(topicDetail.getTitle())) {
                                            mTvTitle.setText(topicDetail.getTitle());
                                        }
                                        if (!TextUtils.isEmpty(topicDetail.getSummary())) {
                                            mTvSummary.setText(topicDetail.getSummary());
                                        }
                                        if (!TextUtils.isEmpty(topicDetail.getPublishDate())) {
                                            mTvTime.setText(topicDetail.getPublishDate());
                                        }
                                    }
                                    mNewsDetailAdapter.setNewData(topicDetail.getNewsArray());
                    }

                    @Override
                    public void onError(Throwable e) {
                        ToastHelper.showToast(e.toString());
                    }

                    @Override
                    public void onComplete() {
                        mActivity.dismissLoading();

                    }
                });





    }
}
