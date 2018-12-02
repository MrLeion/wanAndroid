package tzl.com.awesomewanandroid.ui.news.detail;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.base.WBaseActivity;
import tzl.com.framework.data.AppConfig;

public class NewsDetailActivity extends WBaseActivity<NewsDetailPresenter> implements NewsDetailView {

    @BindView(R.id.tv_common_toolbar_title)
    TextView     mTvCommonToolbarTitle;
    @BindView(R.id.tvTitle)
    TextView     mTvTitle;
    @BindView(R.id.tvTime)
    TextView     mTvTime;
    @BindView(R.id.tvSummary)
    TextView     mTvSummary;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.titleView)
    Toolbar      mTitleView;
    private String mTopicId;

    @Override
    public int getLayoutId() {
        return R.layout.activity_news_detail;
    }

    @Override
    public void initView() {
        mPresenter = new NewsDetailPresenter(this, new NewsDetailModel());
        handleIntent(getIntent());
    }

    private void handleIntent(Intent intent) {
        if (intent != null) {
            mTopicId = intent.getStringExtra(AppConfig.TOPICID);
        }
        mTvCommonToolbarTitle.setText("新闻详情");
        mTitleView.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void initEvent() {
    }

    @Override
    public void initData() {


    }


    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.loadData(mTopicId);
    }

    public TextView getTvCommonToolbarTitle() {
        return mTvCommonToolbarTitle;
    }

    public TextView getTvTitle() {
        return mTvTitle;
    }

    public TextView getTvTime() {
        return mTvTime;
    }

    public TextView getTvSummary() {
        return mTvSummary;
    }

    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }


}
