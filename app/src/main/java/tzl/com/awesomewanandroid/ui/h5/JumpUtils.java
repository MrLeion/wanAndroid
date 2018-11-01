package tzl.com.awesomewanandroid.ui.h5;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

/**
 * author: tangzenglei
 * created on: 2018/10/29 下午4:24
 * description:
 */
public class JumpUtils {



    public static void startH5(Context context,String url) {
        if (!TextUtils.isEmpty(url)&&url.startsWith("http")) {
            Bundle b = new Bundle();
            b.putString(H5Activity.H5_URL,url);
            H5Activity.startActivity(context,b);
        }
    }

}
