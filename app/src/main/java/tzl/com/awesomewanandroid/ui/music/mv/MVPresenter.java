package tzl.com.awesomewanandroid.ui.music.mv;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.adapter.MvAdapter;
import tzl.com.framework.base.BasePresenter;

/**
 * author: tangzenglei
 * created on: 2018/10/10 下午2:38
 * description:
 */
public class MVPresenter extends BasePresenter<MVView,MVModel> {

    private final RecyclerView mChartsArtistRcv;
    private String src = "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4";
    private MvAdapter mAdapter;

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

    public void loadData() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        mChartsArtistRcv.setLayoutManager(layoutManager);
        mAdapter = new MvAdapter(R.layout.item_mv, mActivity);
        mChartsArtistRcv.setAdapter(mAdapter);
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strings.add("hello world"+i);
        }
        mAdapter.setNewData(strings);

    }
}
