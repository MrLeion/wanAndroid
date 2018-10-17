package tzl.com.awesomewanandroid.ui.music.discovery;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import tzl.com.framework.base.IView;
import tzl.com.framework.widget.multistatusview.MultipleStatusView;

/**
 * author: tangzenglei
 * created on: 2018/10/10 下午2:39
 * description:
 */
public interface DiscoveryView extends IView {

    TextView getSeeAllArtistTv();

    RecyclerView getRvHotSingers();

    SmartRefreshLayout getRefreshLayout();

    MultipleStatusView getMultistatusview();

}
