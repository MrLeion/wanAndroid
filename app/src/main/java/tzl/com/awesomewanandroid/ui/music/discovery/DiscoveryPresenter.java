package tzl.com.awesomewanandroid.ui.music.discovery;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import tzl.com.framework.base.BasePresenter;
import tzl.com.framework.widget.multistatusview.MultipleStatusView;

/**
 * author: tangzenglei
 * created on: 2018/10/10 下午2:38
 * description:
 */
public class DiscoveryPresenter extends BasePresenter<DiscoveryView,DiscoveryModel> {


    private MultipleStatusView mMultistatusview;
    private SmartRefreshLayout mRefreshLayout;
    private RecyclerView mRvHotSingers;
    private TextView mSeeAllArtistTv;

    /**
     * 绑定 View 和 model
     * @param view
     * @param model
     */
    public DiscoveryPresenter(DiscoveryView view, DiscoveryModel model) {
        super(view, model);
    }

    @Override
    public void init() {
        mMultistatusview = mView.getMultistatusview();
        mRefreshLayout = mView.getRefreshLayout();
        mRvHotSingers = mView.getRvHotSingers();
        mSeeAllArtistTv = mView.getSeeAllArtistTv();
        mRvHotSingers.setLayoutManager(new LinearLayoutManager(mActivity,LinearLayoutManager.HORIZONTAL,false));

    }

    @Override
    public void registerEvent() {

    }
}
