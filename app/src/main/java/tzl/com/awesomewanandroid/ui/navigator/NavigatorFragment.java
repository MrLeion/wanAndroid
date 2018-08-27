package tzl.com.awesomewanandroid.ui.navigator;

import android.os.Bundle;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.base.WBaseFragment;

/**
 * author: tangzenglei
 * created on: 2018/8/27 下午4:00
 * description:体系
 */
public class NavigatorFragment extends WBaseFragment {


    public static NavigatorFragment newInstance(String title) {
        NavigatorFragment fragment = new NavigatorFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_navigator;
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
