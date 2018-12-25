package tzl.com.awesomewanandroid.ui.music.discovery;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.base.XBaseLazyFragment;
import tzl.com.framework.widget.multistatusview.MultipleStatusView;

/**
 * author: tangzenglei
 * created on: 2018/10/10 下午3:53
 * description: 发现界面
 */
public class DiscoveryFragment extends XBaseLazyFragment<DiscoveryPresenter> implements DiscoveryView {


    @BindView(R.id.seeAllArtistTv)
    TextView           mSeeAllArtistTv;
    @BindView(R.id.rvHotSingers)
    RecyclerView       mRvHotSingers;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.multistatusview)
    MultipleStatusView mMultistatusview;
    private DiscoveryPresenter mDiscoveryPresenter;

    public static DiscoveryFragment newInstance() {
        DiscoveryFragment discoveryFragment = new DiscoveryFragment();
        return discoveryFragment;
    }

    @Override
    protected void onLazyLoad() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_discovery;
    }

    @Override
    public void initView() {
        mDiscoveryPresenter = new DiscoveryPresenter(this, new DiscoveryModel());
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initData() {

        mDiscoveryPresenter.loadData();


    }

    public TextView getSeeAllArtistTv() {
        return mSeeAllArtistTv;
    }

    public RecyclerView getRvHotSingers() {
        return mRvHotSingers;
    }

    public SmartRefreshLayout getRefreshLayout() {
        return mRefreshLayout;
    }

    public MultipleStatusView getMultistatusview() {
        return mMultistatusview;
    }
}
