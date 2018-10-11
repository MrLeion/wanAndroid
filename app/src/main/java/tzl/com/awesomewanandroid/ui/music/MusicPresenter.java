package tzl.com.awesomewanandroid.ui.music;

import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import tzl.com.awesomewanandroid.base.WBaseFragment;
import tzl.com.awesomewanandroid.base.WBaseFragmentPagerAdapter;
import tzl.com.awesomewanandroid.ui.music.discovery.DiscoveryFragment;
import tzl.com.awesomewanandroid.ui.music.mv.MVFragment;
import tzl.com.framework.base.BasePresenter;

/**
 * author: tangzenglei
 * created on: 2018/10/10 下午2:38
 * description:
 */
public class MusicPresenter extends BasePresenter<MusicView,MusicModel> {

    private final SlidingTabLayout mStlMusic;
    private final ViewPager mViewPager;
    private ArrayList<WBaseFragment> mWBaseFragments;

    /**
     * 绑定 View 和 model
     *
     * @param view
     * @param model
     */
    public MusicPresenter(MusicView view, MusicModel model) {
        super(view, model);
        mStlMusic = mView.getStlMusic();
        mViewPager = mView.getViewPager();

        initView();
    }

    private void initView() {
        mWBaseFragments = new ArrayList<>();
        mWBaseFragments.add(DiscoveryFragment.newInstance());
        mWBaseFragments.add(MVFragment.newInstance());
        List<String> titles = new ArrayList<>();
        titles.add("发现");
        titles.add("MV");
        WBaseFragmentPagerAdapter wBaseFragmentPagerAdapter = new WBaseFragmentPagerAdapter(mActivity.getSupportFragmentManager(), mWBaseFragments, titles);
        mViewPager.setAdapter(wBaseFragmentPagerAdapter);
        mStlMusic.setViewPager(mViewPager);
    }

    @Override
    public void init() {

    }



    @Override
    public void registerEvent() {

    }
}
