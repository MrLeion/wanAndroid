package tzl.com.awesomewanandroid.ui.h5;

import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.just.agentweb.AgentWebUIControllerImplBase;
import com.just.agentweb.DefaultWebClient;
import com.just.agentweb.IAgentWebSettings;
import com.just.agentweb.IWebLayout;
import com.just.agentweb.MiddlewareWebChromeBase;
import com.just.agentweb.MiddlewareWebClientBase;
import com.just.agentweb.PermissionInterceptor;

/**
 * author: tangzenglei
 * created on: 2018/10/29 下午2:50
 * description:
 */
public interface IWebviewConfig {

    String url();

    IAgentWebSettings agentWebSettings();

    MiddlewareWebClientBase middleWareWebClient();

    MiddlewareWebChromeBase middleWareWebChrome();

    DefaultWebClient.OpenOtherPageWays openOtherAppWay();

    AgentWebUIControllerImplBase agentWebUIController();

    IWebLayout webLayout();

    PermissionInterceptor permissionInterceptor();

    WebView webView();

    WebViewClient webViewClient();

    WebChromeClient webChromeClient();

    int indicatorHeight();

    int indicatorColor();

    ViewGroup agentWebContainer();


    IAgentWebSettings webViewSettings();
}
