package tzl.com.awesomewanandroid.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import tzl.com.framework.helper.LogHelper;

/**
 * author: tangzenglei
 * created on: 2018/8/22 下午5:30
 * description:http://www.sunnyang.com/742.html
 */
public abstract class WBaseLazyFragment extends WBaseFragment {

    protected WBaseActivity mActivity;

    /**
     * 懒加载
     */
    //页面控件创建标志
    protected boolean isPrepared;

    //页面是否已经加载数据
    protected boolean isInitialized;



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isPrepared = true;
        //解决第一个页面无法加载
        setUserVisibleHint(getUserVisibleHint());
    }



    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser
                &&isPrepared
                &&!isInitialized) {
            onLazyLoad();
            isInitialized = true;
        }
    }

    protected abstract void onLazyLoad();


    @Override
    public void onDestroy() {
        super.onDestroy();
        //重置加载位
        isPrepared = false;
        isInitialized = false;
        LogHelper.e("onDestroy wBaseFragment:"+isPrepared +isInitialized);
    }



}
