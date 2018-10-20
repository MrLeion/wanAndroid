package tzl.com.awesomewanandroid.ui.news;

import android.support.v7.widget.RecyclerView;

import tzl.com.framework.base.IView;
import tzl.com.framework.widget.multistatusview.MultipleStatusView;

/**
 * author: tangzenglei
 * created on: 2018/9/5 下午2:30
 * description:
 */
public interface NewsView extends IView {


    RecyclerView getRecyclerView();

    MultipleStatusView getMultistatusview();

}
