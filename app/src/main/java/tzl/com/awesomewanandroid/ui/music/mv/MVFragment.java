package tzl.com.awesomewanandroid.ui.music.mv;

import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.base.XBaseLazyFragment;

/**
 * author: tangzenglei
 * created on: 2018/10/10 下午3:53
 * description: 发现界面
 */
public class MVFragment extends XBaseLazyFragment<MVPresenter> implements MVView {


    @BindView(R.id.chartsArtistRcv)
    RecyclerView mChartsArtistRcv;
    private MVPresenter mMVPresenter;


    public static MVFragment newInstance() {
        MVFragment mvFragment = new MVFragment();
        return mvFragment;
    }


    @Override
    protected void onLazyLoad() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mv;
    }

    @Override
    public void initView() {
        mMVPresenter = new MVPresenter(this, new MVModel());
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initData() {
        mMVPresenter.loadData();
    }


    public RecyclerView getChartsArtistRcv() {
        return mChartsArtistRcv;
    }
}
