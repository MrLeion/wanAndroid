package tzl.com.awesomewanandroid.ui.news;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.base.WBaseActivity;
import tzl.com.framework.widget.multistatusview.MultipleStatusView;

public class NewsActivity extends WBaseActivity implements NewsView {


    @BindView(R.id.recyclerView)
    RecyclerView       mRecyclerView;
    @BindView(R.id.multistatusview)
    MultipleStatusView mMultistatusview;
    @BindView(R.id.titleView)
    Toolbar            mTitleView;
    private NewsPresenter mNewsPresenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_news;
    }

    @Override
    public void initView() {
        mNewsPresenter = new NewsPresenter(this, new NewsModel());
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
        mNewsPresenter.loadData();
    }


    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    public MultipleStatusView getMultistatusview() {
        return mMultistatusview;
    }

}
