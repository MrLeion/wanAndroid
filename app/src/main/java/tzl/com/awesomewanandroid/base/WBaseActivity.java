package tzl.com.awesomewanandroid.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import tzl.com.framework.base.BaseActivity;
import tzl.com.framework.helper.ActivityManager;
import tzl.com.framework.widget.dialog.QMUITipDialog;

/**
 * author: tangzenglei
 * created on: 2018/7/27 上午11:02
 * description:玩 Android 应用 BaseActivity
 */
public abstract class WBaseActivity extends BaseActivity {


    private QMUITipDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());

        //TODO:状态栏处理
        initView();
        initEvent();
        initData();
        ActivityManager.add(this);



    }



    /**
     * 显示加载 DialogLoading
     * @param tip 提示文字
     */
    public void showLoading(String tip) {
        showDialog(tip, QMUITipDialog.Builder.ICON_TYPE_LOADING);
    }

    private void showDialog(String tip, int iconType) {
        dismissLoading();
        try {
            mProgressDialog = new QMUITipDialog.Builder(this)
                    .setIconType(iconType)
                    .setTipWord(tip)
                    .create();
            mProgressDialog.setCancelable(false);
            mProgressDialog.setOnCancelListener(null);
            if (!isFinishing()) {
                mProgressDialog.show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showLoading() {
        showLoading("加载中...");
    }


    public void dismissLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            try {
                mProgressDialog.dismiss();
                mProgressDialog = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


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

    /**
     * 获取 Activity 布局
     * @return
     */
    public abstract int getLayoutId() ;

    /**
     * 初始化 view
     */
    public abstract void initView();

    /**
     * 初始化 监听器
     */
    public abstract void initEvent();

    /**
     * 初始化 Data
     */
    public abstract void initData();


}
