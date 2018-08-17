package tzl.com.awesomewanandroid.testExample;

import android.view.View;
import android.widget.ImageView;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.base.WBaseActivity;
import tzl.com.framework.glide.GlideImageLoader;

public class TestGlideActivity extends WBaseActivity {





    private ImageView imageView;
    String url = "https://www.baidu.com/img/bd_logo1.png";


    @Override
    public int getLayoutId() {
        return R.layout.activity_test_glide;
    }

    @Override
    public void initView() {
        imageView = findViewById(R.id.iv);
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initData() {

    }

    public void customGlide(View view) {
        GlideImageLoader.loadCircle(this,imageView,url,R.mipmap.ic_launcher,R.mipmap.ic_launcher);

    }

    public void roundGlide(View view) {
        GlideImageLoader.loadRound(this,imageView,url,R.mipmap.ic_launcher,R.mipmap.ic_launcher);
    }

    public void blurGlide(View view) {

        GlideImageLoader.loadBlur(this,imageView,url,R.mipmap.ic_launcher,R.mipmap.ic_launcher);
    }
}
