package tzl.com.framework.net.cookie;

import android.content.Context;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import tzl.com.framework.net.cookie.store.PersistentCookieStore;

/**
 * author: tangzenglei
 * created on: 2018/8/21 下午4:57
 * description:
 */
public class CookieManger implements CookieJar{

    private static Context mContext;

    private static PersistentCookieStore cookieStore;

    public CookieManger(Context context) {
        mContext = context;
        if (cookieStore == null ) {
            cookieStore = new PersistentCookieStore(mContext);
        }

    }



    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        if (cookies != null && cookies.size() > 0) {
            for (Cookie item : cookies) {
                cookieStore.add(url, item);
            }
        }
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        List<Cookie> cookies =cookieStore.get(url);
        return cookies;
    }
}
