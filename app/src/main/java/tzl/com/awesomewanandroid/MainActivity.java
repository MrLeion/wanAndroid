package tzl.com.awesomewanandroid;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import butterknife.BindView;
import tzl.com.awesomewanandroid.base.WBaseActivity;
import tzl.com.awesomewanandroid.ui.hierarchy.HierarchyFragment;
import tzl.com.awesomewanandroid.ui.home.HomeFragment;
import tzl.com.awesomewanandroid.ui.music.MusicFragment;
import tzl.com.awesomewanandroid.ui.navigator.NavigatorFragment;
import tzl.com.awesomewanandroid.ui.project.ProjectListFragment;
import tzl.com.awesomewanandroid.ui.video.VideoFragment;
import tzl.com.framework.base.BaseFragment;
import tzl.com.framework.helper.TabManager;
import tzl.com.framework.widget.anim.Rotate3dFrameLayout;

public class MainActivity extends WBaseActivity {


    public static final String TAG_HOME      = "home";
    public static final String TAG_NAV       = "navigator";
    public static final String TAG_HIERARCHY = "hierarchy";
    public static final String TAG_PROJECT   = "project";
    public static final String TAG_MUSIC     = "music";
    public static final String TAG_VIDEO     = "video";
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
    @BindView(R.id.rlMenuCode)
    RelativeLayout      mRlMenuCode;
    @BindView(R.id.container)
    Rotate3dFrameLayout mContainer;
    @BindView(R.id.rbMusic)
    RadioButton         mRbMusic;
    @BindView(R.id.rbVideo)
    RadioButton         mRbVideo;
    @BindView(R.id.restRadioGroup)
    RadioGroup          mRestRadioGroup;

    private TabManager   mWanAndroidTabManager;
    private TabManager   mRestTabManager;
    private BaseFragment currentFragmentWandroid;
    private BaseFragment currentFragmentRest;
    private String  currentWanAndroidTag = TAG_HOME; //默认首页
    private String  currentRestTag = TAG_HOME; //默认音乐
    private boolean isFirst              = true;//默认第一面


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        initAndroid();
        initRest();
        setTabEvent();
    }

    private void initRest() {
        mRestTabManager = new TabManager(R.id.fl_content_rest, getSupportFragmentManager());
        mRestTabManager.addFragment(TAG_MUSIC, MusicFragment.class);
        mRestTabManager.addFragment(TAG_VIDEO, VideoFragment.class);
        switchRestFragment(TAG_MUSIC);
    }

    private void initAndroid() {
        mWanAndroidTabManager = new TabManager(R.id.fl_content_wanandroid, getSupportFragmentManager());
        mWanAndroidTabManager.addFragment(TAG_HOME, HomeFragment.class);
        mWanAndroidTabManager.addFragment(TAG_NAV, NavigatorFragment.class);
        mWanAndroidTabManager.addFragment(TAG_HIERARCHY, HierarchyFragment.class);
        mWanAndroidTabManager.addFragment(TAG_PROJECT, ProjectListFragment.class);
        switchWanAndroidFragment(TAG_HOME);
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initData() {


    }


    /**
     * wanandroid 切换 Fragment
     *
     * @param tag
     */
    public void switchWanAndroidFragment(String tag) {
        mWanAndroidTabManager.setTab(tag);
        currentWanAndroidTag = tag;
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
        currentFragmentWandroid = mWanAndroidTabManager.getCurrentFragment();
    }

    /**
     * 休息一下 切换 Fragment
     *
     * @param tag
     */
    public void switchRestFragment(String tag) {
        mRestTabManager.setTab(tag);
        currentRestTag = tag;
        switch (tag) {
            case TAG_VIDEO:
                mRbVideo.setChecked(true);
                break;
            case TAG_MUSIC:
            default:
                mRbMusic.setChecked(true);
                break;
        }
        currentFragmentRest = mRestTabManager.getCurrentFragment();
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
                        switchWanAndroidFragment(TAG_PROJECT);
                        break;
                    case R.id.rbNavigator:
                        switchWanAndroidFragment(TAG_NAV);
                        break;
                    case R.id.rbHierarchy:
                        switchWanAndroidFragment(TAG_HIERARCHY);
                        break;
                    case R.id.rbHome:
                    default:
                        switchWanAndroidFragment(TAG_HOME);
                        break;
                }
            }
        });
        mRestRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbVideo:
                        switchRestFragment(TAG_VIDEO);
                        break;
                    case R.id.rbMusic:
                    default:
                        switchRestFragment(TAG_MUSIC);
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
        mRlMenuCode.setOnClickListener(onClickListener);
    }


}
