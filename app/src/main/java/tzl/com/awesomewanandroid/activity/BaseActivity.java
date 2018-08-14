package tzl.com.awesomewanandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * author: tangzenglei
 * created on: 2018/7/27 上午11:02
 * description:
 */
public class BaseActivity extends AppCompatActivity {

    public  void startActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        if (intent.resolveActivity(getPackageManager())!=null) {
            startActivity(intent);
        }else{
            //todo 提示添加清单文件

        }

    }



    /**
     * 跳转页面
     * @param clz    所跳转的目的Activity类
     * @param bundle 跳转所携带的信息
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent(this, clz);
        if (intent.resolveActivity(getPackageManager()) != null) {

            if (bundle != null) {
                intent.putExtras(bundle);
            }
            this.startActivity(intent);
        }else{
        //todo 提示添加清单文件


       }
    }

}
