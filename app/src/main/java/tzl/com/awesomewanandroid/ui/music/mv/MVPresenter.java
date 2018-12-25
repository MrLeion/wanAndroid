package tzl.com.awesomewanandroid.ui.music.mv;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shuyu.gsyvideoplayer.utils.CommonUtil;

import java.util.ArrayList;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.adapter.MvAdapter;
import tzl.com.awesomewanandroid.helper.ScrollCalculatorHelper;
import tzl.com.framework.base.BasePresenter;

/**
 * author: tangzenglei
 * created on: 2018/10/10 下午2:38
 * description: MV 自动播放列表
 */
public class MVPresenter extends BasePresenter<MVView,MVModel> {

    private final RecyclerView mChartsArtistRcv;
    private MvAdapter mAdapter;
    private ScrollCalculatorHelper scrollCalculatorHelper;

    /**
     * 绑定 View 和 model
     * @param view
     * @param model
     */
    public MVPresenter(MVView view, MVModel model) {
        super(view, model);
        mChartsArtistRcv = mView.getChartsArtistRcv();
    }

    @Override
    public void init() {

    }

    @Override
    public void registerEvent() {

    }

    public void loadData(boolean isFull) {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strings.add("hello world"+i);
        }
        //限定范围为屏幕一半的上下偏移180
        int playTop = CommonUtil.getScreenHeight(mActivity) / 2 - CommonUtil.dip2px(mActivity, 180);
        int playBottom = CommonUtil.getScreenHeight(mActivity) / 2 + CommonUtil.dip2px(mActivity, 180);
        //自动播放帮助类
        scrollCalculatorHelper = new ScrollCalculatorHelper(R.id.cover, playTop, playBottom);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        mChartsArtistRcv.setLayoutManager(layoutManager);
        mAdapter = new MvAdapter(R.layout.item_mv, mActivity);
        mChartsArtistRcv.setAdapter(mAdapter);
        mAdapter.setNewData(strings);
        mChartsArtistRcv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int firstVisibleItem, lastVisibleItem;
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                scrollCalculatorHelper.onScrollStateChanged(recyclerView, newState);
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                firstVisibleItem = layoutManager.findFirstVisibleItemPosition();
                lastVisibleItem = layoutManager.findLastVisibleItemPosition();
                //这是滑动自动播放的代码
                if (!isFull) {
                    scrollCalculatorHelper.onScroll(recyclerView, firstVisibleItem, lastVisibleItem, lastVisibleItem - firstVisibleItem);
                }
            }
        });
    }
}
