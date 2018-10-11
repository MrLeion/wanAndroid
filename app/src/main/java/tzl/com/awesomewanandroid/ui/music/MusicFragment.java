package tzl.com.awesomewanandroid.ui.music;

import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;

import butterknife.BindView;
import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.base.WBaseFragment;

/**
 * author: tangzenglei
 * created on: 2018/8/27 下午4:00
 * description:音乐
 */
public class MusicFragment extends WBaseFragment<MusicPresenter> implements MusicView {


    @BindView(R.id.stlMusic)
    SlidingTabLayout mStlMusic;
    @BindView(R.id.viewPager)
    ViewPager        mViewPager;
    private MusicPresenter mMusicPresenter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_music;
    }


    @Override
    public void initView() {

        mMusicPresenter = new MusicPresenter(this, new MusicModel());


    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initData() {

    }


    public SlidingTabLayout getStlMusic() {
        return mStlMusic;
    }

    public ViewPager getViewPager() {
        return mViewPager;
    }
}
