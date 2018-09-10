package tzl.com.awesomewanandroid.ui.home;

import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import tzl.com.framework.base.IView;

/**
 * author: tangzenglei
 * created on: 2018/9/6 上午9:32
 * description:
 */
public interface HomeView extends IView {


    RecyclerView getRecyclerView();

    SmartRefreshLayout getRefreshLayout();


}
