package tzl.com.awesomewanandroid.testExample.customView;

import android.widget.Button;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.base.WBaseActivity;

public class TestWindowActivity extends WBaseActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_test_window;
    }

    @Override
    public void initView() {


        Button button = new Button(this);

    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initData() {

    }
}
