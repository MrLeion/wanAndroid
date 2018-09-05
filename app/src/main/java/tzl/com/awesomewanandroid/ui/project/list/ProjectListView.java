package tzl.com.awesomewanandroid.ui.project.list;

import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;

import tzl.com.framework.base.IView;
import tzl.com.framework.widget.multistatusview.MultipleStatusView;

/**
 * author: tangzenglei
 * created on: 2018/9/5 上午10:40
 * description:
 */
public interface ProjectListView extends IView{


    SlidingTabLayout getStlProject();

    ViewPager getViewPager();

    MultipleStatusView getMultistatusview();





}
