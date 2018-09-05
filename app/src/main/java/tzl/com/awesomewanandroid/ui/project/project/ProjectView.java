package tzl.com.awesomewanandroid.ui.project.project;

import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import tzl.com.framework.base.IView;
import tzl.com.framework.widget.multistatusview.MultipleStatusView;

/**
 * author: tangzenglei
 * created on: 2018/9/5 下午1:40
 * description:
 */
public interface ProjectView extends IView {


    RecyclerView getRecyclerView();

    MultipleStatusView getMultistatusview();

    SmartRefreshLayout getRefreshLayout();
}
