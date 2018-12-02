package tzl.com.awesomewanandroid.ui.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.base.XBaseFragment;

/**
 * author: tangzenglei
 * created on: 2018/8/27 下午4:00
 * description:首页
 */
public class HomeFragment extends XBaseFragment<HomePresenter> implements HomeView {


    @BindView(R.id.recyclerView)
    RecyclerView       mRecyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerView.setHasFixedSize(true);
    }

    @Override
    public void initEvent() {
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mPresenter.getBanner();
                mPresenter.getArticle();
            }
        });
    }

    @Override
    public void initData() {
        mPresenter = new HomePresenter(this, new HomeModel());
        mPresenter.getBanner();
        mPresenter.getArticle();
    }





    @Override
    public void onResumeFragment() {
        super.onResumeFragment();
        mPresenter.getBanner();
        mPresenter.getArticle();
    }

    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }


    public SmartRefreshLayout getRefreshLayout() {
        return mRefreshLayout;
    }

}
