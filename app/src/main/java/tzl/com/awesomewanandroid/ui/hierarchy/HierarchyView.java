package tzl.com.awesomewanandroid.ui.hierarchy;

import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import tzl.com.framework.base.IView;
import tzl.com.framework.widget.multistatusview.MultipleStatusView;

/**
 * author: tangzenglei
 * created on: 2018/9/10 上午11:53
 * description:
 */
public interface HierarchyView extends IView {


    RecyclerView getRecyclerView();

    SmartRefreshLayout getRefreshLayout();

    MultipleStatusView getMultistatusview();
}
