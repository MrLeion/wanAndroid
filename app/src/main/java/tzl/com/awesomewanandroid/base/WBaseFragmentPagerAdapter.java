package tzl.com.awesomewanandroid.base;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

import tzl.com.framework.base.BaseFragmentPagerAdapter;

/**
 * author: tangzenglei
 * created on: 2018/8/28 下午4:13
 * description:
 */
public class WBaseFragmentPagerAdapter extends BaseFragmentPagerAdapter {


    private final List<XBaseFragment> mWBaseFragments;
    private final List<String>        titles;

    public WBaseFragmentPagerAdapter(FragmentManager fragmentManager, List<XBaseFragment> fragments, List<String> titles) {
        super(fragmentManager);
        this.mWBaseFragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mWBaseFragments.get(position);
    }

    @Override
    public int getCount() {
        if (null == mWBaseFragments) {
            return 0;
        }
        return mWBaseFragments.size();
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
