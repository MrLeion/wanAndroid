package tzl.com.awesomewanandroid.ui.music.discovery;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.base.WBaseLazyFragment;

/**
 * author: tangzenglei
 * created on: 2018/10/10 下午3:53
 * description: 发现界面
 */
public class DiscoveryFragment extends WBaseLazyFragment<DiscoveryPresenter>{



    public static DiscoveryFragment newInstance() {
        DiscoveryFragment discoveryFragment = new DiscoveryFragment();
        return discoveryFragment;
    }

    @Override
    protected void onLazyLoad() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_discovery;
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
