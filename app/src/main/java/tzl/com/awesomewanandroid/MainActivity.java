package tzl.com.awesomewanandroid;

import android.os.Bundle;
import android.view.View;

import tzl.com.awesomewanandroid.activity.BaseActivity;
import tzl.com.awesomewanandroid.testExample.TestGlideActivity;
import tzl.com.awesomewanandroid.testExample.TestRetrofitActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void jumpGlide(View view) {
        startActivity(TestGlideActivity.class);
    }

    public void jumpRetrofitActivity(View view) {
        startActivity(TestRetrofitActivity.class);
    }
}
