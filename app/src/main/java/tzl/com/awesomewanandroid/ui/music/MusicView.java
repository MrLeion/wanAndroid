package tzl.com.awesomewanandroid.ui.music;

import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;

import tzl.com.framework.base.IView;

/**
 * author: tangzenglei
 * created on: 2018/10/10 下午2:39
 * description:
 */
public interface MusicView extends IView {


    SlidingTabLayout getStlMusic();

    ViewPager getViewPager();



}
