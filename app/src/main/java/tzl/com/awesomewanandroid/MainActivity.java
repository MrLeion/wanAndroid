package tzl.com.awesomewanandroid;

import android.view.View;

import tzl.com.awesomewanandroid.base.WBaseActivity;
import tzl.com.awesomewanandroid.testExample.TestGlideActivity;
import tzl.com.awesomewanandroid.testExample.TestRetrofitActivity;

public class MainActivity extends WBaseActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
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


    public void jumpGlide(View view) {
        startActivity(TestGlideActivity.class);
    }

    public void jumpRetrofitActivity(View view) {
        startActivity(TestRetrofitActivity.class);
    }


}
