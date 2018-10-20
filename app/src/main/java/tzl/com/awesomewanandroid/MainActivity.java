package tzl.com.awesomewanandroid;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import tzl.com.awesomewanandroid.base.WBaseActivity;
import tzl.com.awesomewanandroid.testExample.TestListActivity;
import tzl.com.awesomewanandroid.ui.hierarchy.HierarchyFragment;
import tzl.com.awesomewanandroid.ui.home.HomeFragment;
import tzl.com.awesomewanandroid.ui.music.MusicFragment;
import tzl.com.awesomewanandroid.ui.navigator.NavigatorFragment;
import tzl.com.awesomewanandroid.ui.news.NewsActivity;
import tzl.com.awesomewanandroid.ui.project.ProjectListFragment;
import tzl.com.awesomewanandroid.ui.video.VideoFragment;
import tzl.com.framework.base.BaseFragment;
import tzl.com.framework.helper.LogHelper;
import tzl.com.framework.helper.TabManager;
import tzl.com.framework.widget.OptionItemView;
import tzl.com.framework.widget.anim.Rotate3dFrameLayout;
import tzl.com.framework.widget.listener.OnViewClickListener;
import tzl.com.framework.widget.statusbar.StatusBarUtil;

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
    @BindView(R.id.titleView)
    Toolbar             mCommonToolbar;
    @BindView(R.id.tv_common_toolbar_title)
    TextView            mTvCommonToolbarTitle;
    @BindView(R.id.drawer_wanandroid)
    DrawerLayout        mDrawerWanandroid;
    @BindView(R.id.oivColletion)
    OptionItemView      mOivColletion;
    @BindView(R.id.oivTodo)
    OptionItemView      mOivTodo;
    @BindView(R.id.oivSetting)
    OptionItemView      mOivSetting;
    @BindView(R.id.oivAboutUs)
    OptionItemView      mOivAboutUs;
    @BindView(R.id.oivLogout)
    OptionItemView      mOivLogout;
    @BindView(R.id.tv_toolbar_title)
    TextView            mTvToolbarTitle;


    private TabManager   mWanAndroidTabManager;
    private TabManager   mRestTabManager;
    private BaseFragment currentFragmentWandroid;
    private BaseFragment currentFragmentRest;
    private String  currentWanAndroidTag = TAG_HOME; //默认首页
    private String  currentRestTag       = TAG_HOME; //默认音乐
    private boolean isWanAndroid         = true;//默认第一面
    private ActionBarDrawerToggle mToggle;


    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    MainActivity.this.startActivity(TestListActivity.class);
                    break;

            }
        }
    };


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        initAndroid();
        initRest();
        initWanAndroidDrawerLayout();
    }

    private void initWanAndroidDrawerLayout() {
        setSupportActionBar(mCommonToolbar);
        //去除默认标题
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Toolbar 监听
        mCommonToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_search:
                        Toast.makeText(MainActivity.this, "Search !", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });


        //侧滑与图标交互处理
        //高仿QQ 效果
        //获取mDrawerLayout中的第一个子布局，也就是布局中的RelativeLayout
        //获取抽屉的view
        //设置左边菜单滑动后的占据屏幕大小
        //设置菜单透明度
        //设置内容界面水平和垂直方向偏转量
        //在滑动时内容界面的宽度为 屏幕宽度减去菜单界面所占宽度
        //设置内容界面操作无效（比如有button就会点击无效）
        //设置右边菜单滑动后的占据屏幕大小
        mToggle = new ActionBarDrawerToggle(
                this, mDrawerWanandroid, mCommonToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                //高仿QQ 效果
                //获取mDrawerLayout中的第一个子布局，也就是布局中的RelativeLayout
                //获取抽屉的view
                View mContent = mDrawerWanandroid.getChildAt(0);
                float scale = 1 - slideOffset;
                float endScale = 0.8f + scale * 0.2f;
                float startScale = 1 - 0.3f * scale;

                //设置左边菜单滑动后的占据屏幕大小
                drawerView.setScaleX(startScale);
                drawerView.setScaleY(startScale);
                //设置菜单透明度
                drawerView.setAlpha(0.6f + 0.4f * (1 - scale));

                //设置内容界面水平和垂直方向偏转量
                //在滑动时内容界面的宽度为 屏幕宽度减去菜单界面所占宽度
                mContent.setTranslationX(drawerView.getMeasuredWidth() * (1 - scale));
                //设置内容界面操作无效（比如有button就会点击无效）
                mContent.invalidate();
                //设置右边菜单滑动后的占据屏幕大小
                mContent.setScaleX(endScale);
                mContent.setScaleY(endScale);

            }


            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                LogHelper.e("MainActivity onDrawerOpened");
            }


            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                LogHelper.e("MainActivity onDrawerClosed");

            }
        };
        mDrawerWanandroid.addDrawerListener(mToggle);
        mToggle.syncState();
    }


    private void initRest() {


        //手动设置状态栏
        StatusBarUtil.darkMode(MainActivity.this);
        try {
            View view = findViewById(R.id.titleRest);
            if (view != null) {
                StatusBarUtil.setPaddingSmart(MainActivity.this, view);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


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
        setTabEvent();
    }

    @Override
    public void initData() {


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //设置toolbar右侧图标
        getMenuInflater().inflate(R.menu.menu_wanandroid_home, menu);
        return super.onCreateOptionsMenu(menu);
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
                mTvCommonToolbarTitle.setText("知识体系");
                break;
            case TAG_NAV:
                mRbNavigator.setChecked(true);
                mTvCommonToolbarTitle.setText("导航");
                break;
            case TAG_PROJECT:
                mRbProject.setChecked(true);
                mTvCommonToolbarTitle.setText("项目");
                break;
            case TAG_HOME:
            default:
                mRbHome.setChecked(true);
                mTvCommonToolbarTitle.setText("首页");
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
                mTvToolbarTitle.setText("视频");
                break;
            case TAG_MUSIC:
            default:
                mRbMusic.setChecked(true);
                mTvToolbarTitle.setText("音乐");
                break;
        }
        currentFragmentRest = mRestTabManager.getCurrentFragment();
    }


    /**
     * 设置底部 button 的点击事件
     */
    private void setTabEvent() {



        mTvToolbarTitle.setOnClickListener(new OnViewClickListener() {
            @Override
            public void onViewOnClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        mHandler.sendEmptyMessage(0);
                    }
                }).start();
            }
        });
//        if (!BuildConfig.ONLINE) {
//
//        }
        setWanAndroidEvent();
        setRestEvent();
        //中间 menu
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //3D 旋转到音视频界面
                mContainer.applyRotation(isWanAndroid);
                isWanAndroid = !isWanAndroid;

            }
        };
        mRlMenuRest.setOnClickListener(onClickListener);
        mRlMenuCode.setOnClickListener(onClickListener);


    }

    private void setRestEvent() {
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
    }

    private void setWanAndroidEvent() {
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
    }


    @OnClick({R.id.oivColletion, R.id.oivTodo, R.id.oivSetting, R.id.oivAboutUs, R.id.oivLogout,R.id.oivNews})
    public void onClickView(View view) {
        switch (view.getId()) {
            case R.id.oivNews:
                startActivity(NewsActivity.class);
                mDrawerWanandroid.closeDrawers();
            break;
            case R.id.oivTodo:
                mDrawerWanandroid.closeDrawers();
                break;
            case R.id.oivColletion:
            mDrawerWanandroid.closeDrawers();
            break;
            case R.id.oivSetting:
                mDrawerWanandroid.closeDrawers();
                break;
            case R.id.oivAboutUs:
                mDrawerWanandroid.closeDrawers();
                break;
            case R.id.oivLogout:
                mDrawerWanandroid.closeDrawers();
                break;
        }

    }

}
