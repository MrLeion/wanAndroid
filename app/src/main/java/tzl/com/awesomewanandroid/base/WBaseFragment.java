package tzl.com.awesomewanandroid.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import tzl.com.framework.base.BaseFragment;

/**
 * author: tangzenglei
 * created on: 2018/8/22 下午5:30
 * description:
 */
public abstract class WBaseFragment extends BaseFragment {

    protected WBaseActivity mActivity;
    private View mRootView;
    private Unbinder mUnbinder;


    /**
     * 懒加载
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //加载view
        if (null==mRootView) {
            mRootView = inflater.inflate(getLayoutId(), null);
            mUnbinder = ButterKnife.bind(mRootView);
        }
        ViewGroup parent= (ViewGroup) mRootView.getParent();
        if(parent!=null){
            parent.removeView(mRootView);
        }
        return mRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initEvent();
        initData();


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof WBaseActivity) {
            this.mActivity = (WBaseActivity) context;
        }
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            dismissLoading();
        }
        if (!hidden) {
            onResumeFragment();
        }else{
            onPauseFragment();
        }
    }




    /**
     * 显示加载 DialogLoading
     * @param tip 提示文字
     */
    public void showLoading(String tip) {
        mActivity.showLoading();
    }

    public void showLoading() {
        showLoading("加载中...");
    }


    public void dismissLoading() {
        mActivity.dismissLoading();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dismissLoading();
        if (null!=mUnbinder) {
            mUnbinder.unbind();
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


    /**
     * 更新数据(fragment创建时不会被调用，当其创建后再次可见时会被调用)
     */

    public void onResumeFragment() {

    }


    /**
     * 更新数据(fragment创建时不会被调用，当其创建后隐藏会被调用)
     */
    public void onPauseFragment() {


    }



}
