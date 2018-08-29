package tzl.com.framework.base;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import tzl.com.framework.helper.LogHelper;

/**
 * @author tangzenglei
 * @desc
 * @date 2017/12/13 上午9:28.
 */

public abstract class BaseFragmentPagerAdapter extends FragmentPagerAdapter {


    public BaseFragmentPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    /**
     * 复写此方法来解决空指针Crash
     * "http://blog.csdn.net/shineflowers/article/details/64125260"
     * "https://stackoverflow.com/questions/41650721/attempt-to-invoke-virtual-method-android-os-handler-android-support-v4-app-frag"
     * @param container
     */
    @Override
    public void finishUpdate(ViewGroup container) {
        try{
            super.finishUpdate(container);
        } catch (NullPointerException e){
            LogHelper.d("Catch the NullPointerException in FragmentPagerAdapter.finishUpdate");
//            e.printStackTrace();
        }
    }
}
