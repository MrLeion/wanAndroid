package tzl.com.awesomewanandroid.testExample;

import android.view.View;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.base.WBaseActivity;

public class TestListActivity extends WBaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_list;
    }

    @Override
    public void initView() {
        showToast("read the fucking source code");
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initData() {

    }

    public void gotoActivity(View view) {
        startActivity(TestDialogActivity.class);
//        showToast("hello toasthello toasthello toasthello toasthello toasthello toasthello toasthello toasthello toasthello toasthello toasthello toasthello toasthello toasthello toasthello toasthello toasthello toasthello toast");
    }
}
