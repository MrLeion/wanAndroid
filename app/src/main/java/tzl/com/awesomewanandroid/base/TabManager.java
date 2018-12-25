package tzl.com.awesomewanandroid.base;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

import tzl.com.framework.base.BaseFragment;

/**
 *  fragment 管理
 */
public class TabManager {

    private int             mContainerViewId;
    private FragmentManager mFragmentManager;
    private XBaseFragment mCurrentFragment = null;
    private String       mCurrentTag      = null;

    private Map<String, Class> mFragmentMap = new HashMap<>();

    public TabManager(@IdRes int containerViewId, FragmentManager fragmentManager) {
        mContainerViewId = containerViewId;
        mFragmentManager = fragmentManager;
    }

    public void addFragment(String tag, Class fragmentClass) {
        if (TextUtils.isEmpty(tag) || fragmentClass == null) {
            return;
        }
        mFragmentMap.put(tag, fragmentClass);
    }

    public void setTab(String tag) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if (isFragmentShown(transaction, tag)) {
            return;
        }

        Fragment fragment = mFragmentManager.findFragmentByTag(tag);
        if (fragment == null) {
            fragment = getFragmentByTag(tag);
            transaction.add(mContainerViewId, fragment, tag);
        } else {
            if (fragment.getClass().equals(mFragmentMap.get(tag))) {
                transaction.show(fragment);
            }  else {
                fragment = getFragmentByTag(tag);
                transaction.replace(mContainerViewId, fragment, tag);
            }
        }
        transaction.commitAllowingStateLoss();
        mCurrentFragment = (XBaseFragment) fragment;
        mCurrentTag = tag;
    }

    private boolean isFragmentShown(FragmentTransaction transaction, String newTag) {
        if (TextUtils.isEmpty(mCurrentTag) || mCurrentFragment == null) {
            return false;
        }

        if (TextUtils.equals(newTag, mCurrentTag)) {
            if (mCurrentFragment.getClass().equals(mFragmentMap.get(newTag))) {
                return true;
            }
        } else {
            if (!mCurrentFragment.isHidden()) {
                transaction.hide(mCurrentFragment);
            }
        }
        return false;
    }

    public XBaseFragment getCurrentFragment() {
        return mCurrentFragment;
    }

    public BaseFragment getFragmentByTag(String tag) {
        if (TextUtils.isEmpty(tag)) {
            return null;
        }
        BaseFragment fragment = null;
        try {
            fragment = (BaseFragment) Class.forName(mFragmentMap.get(tag).getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fragment;
    }
}

