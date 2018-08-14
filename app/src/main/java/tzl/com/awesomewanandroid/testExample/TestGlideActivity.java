package tzl.com.awesomewanandroid.testExample;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.activity.BaseActivity;
import tzl.com.framework.glide.GlideImageLoader;

public class TestGlideActivity extends BaseActivity {





    private ImageView imageView;
    String url = "https://www.baidu.com/img/bd_logo1.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_glide);
        imageView = findViewById(R.id.iv);
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
