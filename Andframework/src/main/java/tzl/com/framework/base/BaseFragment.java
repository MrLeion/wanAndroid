package tzl.com.framework.base;

import android.app.Activity;
import android.support.v4.app.Fragment;

/**
 * author: tangzenglei
 * created on: 2018/8/22 下午5:30
 * description:
 */
public abstract class BaseFragment extends Fragment {

    protected Activity mActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }

    /**
     * 显示加载 DialogLoading
     *
     * @param tip 提示文字
     */
    public abstract void showLoading(String tip);

    public void showLoading() {
        showLoading("加载中...");
    }


    public abstract void dismissLoading();

}
