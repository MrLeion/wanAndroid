package tzl.com.awesomewanandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import tzl.com.awesomewanandroid.base.WBaseActivity;
import tzl.com.awesomewanandroid.ui.hierarchy.HierarchyFragment;
import tzl.com.awesomewanandroid.ui.home.HomeFragment;
import tzl.com.awesomewanandroid.ui.navigator.NavigatorFragment;
import tzl.com.awesomewanandroid.ui.project.ProjectFragment;
import tzl.com.framework.base.BaseFragment;
import tzl.com.framework.helper.TabManager;
import tzl.com.framework.widget.anim.Rotate3dFrameLayout;

public class MainActivity extends WBaseActivity {


    public static final String TAG_HOME      = "home";
    public static final String TAG_NAV       = "navigator";
    public static final String TAG_HIERARCHY = "hierarchy";
    public static final String TAG_PROJECT   = "project";
    @BindView(R.id.rbHome)
    RadioButton         mRbHome;
    @BindView(R.id.rbHierarchy)
    RadioButton         mRbHierarchy;
    @BindView(R.id.rlMenuRest)
    RelativeLayout      mRlMenuRest;
    @BindView(R.id.rbNavigator)
    RadioButton         mRbNavigator;
    @BindView(R.id.rbProject)
    RadioButton         mRbProject;
    @BindView(R.id.radioGroup)
    RadioGroup          mRadioGroup;
    @BindView(R.id.tv)
    TextView            mTv;
    @BindView(R.id.container)
    Rotate3dFrameLayout mContainer;

    private TabManager   tabManager;
    private BaseFragment currentFragment;
    private String currentTag = TAG_HOME; //默认首页
    private boolean isFirst = true;//默认第一面


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        tabManager = new TabManager(R.id.fl_content, getSupportFragmentManager());
        tabManager.addFragment(TAG_HOME, HomeFragment.class);
        tabManager.addFragment(TAG_NAV, NavigatorFragment.class);
        tabManager.addFragment(TAG_HIERARCHY, HierarchyFragment.class);
        tabManager.addFragment(TAG_PROJECT, ProjectFragment.class);
        switchFragment(TAG_HOME);
        setTabEvent();
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initData() {


    }


    /**
     * 切换 Fragment
     *
     * @param tag
     */
    public void switchFragment(String tag) {
        tabManager.setTab(tag);
        currentTag = tag;
        switch (tag) {
            case TAG_HIERARCHY:
                mRbHierarchy.setChecked(true);
                break;
            case TAG_NAV:
                mRbNavigator.setChecked(true);
                break;
            case TAG_PROJECT:
                mRbProject.setChecked(true);
                break;
            case TAG_HOME:
            default:
                mRbHome.setChecked(true);
                break;
        }
        currentFragment = tabManager.getCurrentFragment();
    }


    /**
     * 设置底部 button 的点击事件
     */
    private void setTabEvent() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbProject:
                        switchFragment(TAG_PROJECT);
                        break;
                    case R.id.rbNavigator:
                        switchFragment(TAG_NAV);
                        break;
                    case R.id.rbHierarchy:
                        switchFragment(TAG_HIERARCHY);
                        break;
                    case R.id.rbHome:
                    default:
                        switchFragment(TAG_HOME);
                        break;
                }
            }
        });

        //中间 menu
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //3D 旋转到音视频界面
                mContainer.applyRotation(isFirst);
                isFirst = !isFirst;

            }
        };
        mRlMenuRest.setOnClickListener(onClickListener);
        mTv.setOnClickListener(onClickListener);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
