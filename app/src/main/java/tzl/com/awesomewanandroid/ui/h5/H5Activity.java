package tzl.com.awesomewanandroid.ui.h5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.AgentWebUIControllerImplBase;
import com.just.agentweb.DefaultWebClient;
import com.just.agentweb.IAgentWebSettings;
import com.just.agentweb.IWebLayout;
import com.just.agentweb.MiddlewareWebChromeBase;
import com.just.agentweb.MiddlewareWebClientBase;
import com.just.agentweb.PermissionInterceptor;

import butterknife.BindView;
import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.base.WBaseActivity;

public class H5Activity extends WBaseActivity implements IWebviewConfig{


    @BindView(R.id.tv_common_toolbar_title)
    TextView     mTvTitle;
    @BindView(R.id.titleView)
    Toolbar      mTitleView;
    @BindView(R.id.container)
    LinearLayout mContainer;
    WebViewErrorConfig mWebViewErrorConfig = new WebViewErrorConfig();
    private AgentWeb mAgentWeb;
    public static final String H5_URL = "h5_url";


    public static void startActivity(Context context, Bundle bundle) {
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context);
        Intent intent = new Intent(context, H5Activity.class);
        intent.putExtras(bundle);
        ActivityCompat.startActivity(context,intent,activityOptionsCompat.toBundle());
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_h5;
    }

    @Override
    public void initView() {
        setUpView();
        mTitleView.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                H5Activity.this.finish();
            }
        });
        setUpWebview();
        handleIntent(getIntent());
    }

    //设置转场动画
    private void setUpView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(new Explode().setDuration(500));
            getWindow().setExitTransition(new Explode().setDuration(500));
        }
    }

    private void setUpWebview() {
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(agentWebContainer(), new ViewGroup.LayoutParams(-1, -1))
                .useDefaultIndicator(indicatorColor(), indicatorHeight())
                .setWebChromeClient(webChromeClient())
                .setWebViewClient(webViewClient())
                .setAgentWebWebSettings(webViewSettings())
                .setWebView(webView())
                .setPermissionInterceptor(permissionInterceptor())
                .setWebLayout(webLayout())
                .setAgentWebUIController(agentWebUIController())
                .interceptUnkownUrl()
                .setOpenOtherPageWays(openOtherAppWay())
                .useMiddlewareWebChrome(middleWareWebChrome())
                .useMiddlewareWebClient(middleWareWebClient())
                .setAgentWebWebSettings(agentWebSettings())
                .setMainFrameErrorView(mWebViewErrorConfig.errorView(), mWebViewErrorConfig.reloadView())
                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
                .createAgentWeb()
                .ready()
                .go(url());
    }




    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            String url = bundle.getString(H5_URL);
            mAgentWeb.getUrlLoader().loadUrl(url);
        }
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initData() {

    }


    @Override
    protected void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();

    }

    @Override
    protected void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (mAgentWeb.handleKeyEvent(keyCode,event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }

    @Override
    public String url() {
        return null;
    }

    @Override
    public IAgentWebSettings agentWebSettings() {
        return null;
    }

    @Override
    public MiddlewareWebClientBase middleWareWebClient() {

        return null;
    }

    @Override
    public MiddlewareWebChromeBase middleWareWebChrome() {
        return null;
    }

    @Override
    public DefaultWebClient.OpenOtherPageWays openOtherAppWay() {
        return null;
    }

    @Override
    public AgentWebUIControllerImplBase agentWebUIController() {
        return null;
    }

    @Override
    public IWebLayout webLayout() {
        return null;
    }

    @Override
    public PermissionInterceptor permissionInterceptor() {
        return null;
    }

    @Override
    public WebView webView() {
        return null;
    }

    @Override
    public WebViewClient webViewClient() {
        return new MiddlewareWebClientBase(){
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                mAgentWeb.getUrlLoader().loadUrl((request.getUrl().toString()));
                return super.shouldOverrideUrlLoading(view, request);
            }
        };
    }

    @Override
    public WebChromeClient webChromeClient() {
        return new MiddlewareWebChromeBase(){

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                mTvTitle.setText(title);
            }
        };
    }

    @Override
    public int indicatorHeight() {
        return 3;
    }

    @Override
    public int indicatorColor() {
        return Color.parseColor("#111111");
    }

    @Override
    public ViewGroup agentWebContainer() {
        return mContainer;
    }

    @Override
    public IAgentWebSettings webViewSettings() {


        return null;
    }


}
