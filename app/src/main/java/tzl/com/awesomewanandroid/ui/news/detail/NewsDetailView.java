package tzl.com.awesomewanandroid.ui.news.detail;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import tzl.com.framework.base.IView;

/**
 * author: tangzenglei
 * created on: 2018/9/5 下午2:30
 * description:
 */
public interface NewsDetailView extends IView {


    TextView getTvCommonToolbarTitle();

    TextView getTvTitle();

    TextView getTvTime();

    TextView getTvSummary();

    RecyclerView getRecyclerView();

}
