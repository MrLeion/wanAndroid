package tzl.com.awesomewanandroid.ui.h5;

import tzl.com.awesomewanandroid.R;

/**
 * author: tangzenglei
 * created on: 2018/10/29 下午3:21
 * description:
 */
public class WebViewErrorConfig implements IWebErrorviewConfig {
    @Override
    public int errorView() {
        return R.layout.error_web_view;
    }

    @Override
    public int reloadView() {
        return R.id.erro_web_view;
    }
}
