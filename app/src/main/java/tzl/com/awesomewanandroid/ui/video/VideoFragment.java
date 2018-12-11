package tzl.com.awesomewanandroid.ui.video;

import android.widget.FrameLayout;

import butterknife.BindView;
import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.base.XBaseFragment;

/**
 * author: tangzenglei
 * created on: 2018/8/27 下午4:00
 * description:视频
 */
public class VideoFragment extends XBaseFragment {


    @BindView(R.id.container)
    FrameLayout mContainer;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_video;
    }

    @Override
    public void initView() {



    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initData() {

    }

}
