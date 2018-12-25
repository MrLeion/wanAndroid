package tzl.com.awesomewanandroid.ui.music.mv;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.widget.RecyclerView;

import com.shuyu.gsyvideoplayer.GSYVideoManager;

import butterknife.BindView;
import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.base.XBaseLazyFragment;
import tzl.com.framework.helper.LogHelper;

/**
 * author: tangzenglei
 * created on: 2018/10/10 下午3:53
 * description: 发现界面
 */
public class MVFragment extends XBaseLazyFragment<MVPresenter> implements MVView {


    @BindView(R.id.chartsArtistRcv)
    RecyclerView mChartsArtistRcv;
    private MVPresenter mMVPresenter;
    private boolean isFull = false;


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
        mMVPresenter.loadData(isFull);
    }


    public RecyclerView getChartsArtistRcv() {
        return mChartsArtistRcv;
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation != ActivityInfo.SCREEN_ORIENTATION_USER) {
            isFull = false;
        }else{
            isFull = true;
        }
        LogHelper.e("MVFragment onConfigurationChanged");
    }

    @Override
    public void onPauseFragment() {
        GSYVideoManager.onPause();
    }

    @Override
    public void onResumeFragment() {
        GSYVideoManager.onResume();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        GSYVideoManager.releaseAllVideos();
    }


    @Override
    public void onBackPressed() {
        if (GSYVideoManager.backFromWindowFull(mActivity)) {
            return;
        }
    }




}
