package tzl.com.framework.helper;

import android.graphics.Color;

import tzl.com.framework.base.BaseApplication;
import tzl.com.toastlibrary.ToastActivity;

/**
 * author: tangzenglei
 * created on: 2018/8/14 下午4:08
 * description:
 */
public class ToastHelper {


    public static void toast(final String content) {
        if (Util.isMainThread()) {
            showToast(content);
        } else {
            AppExecutors.getInstance().mainThread().execute(new Runnable() {
                @Override
                public void run() {
                    showToast(content);
                }
            });
        }
    }

    public static void toast(final int resId) {
        toast(ContextHolder.getContext().getResources().getString(resId));
    }

    public static void showToast(String content) {
        ToastActivity.showToast(ContextHolder.getContext(),content);
    }

    /**
     * 高仿苹果 Toast
     * @param content
     */
    public static void showCustom(String content){

        MToastConfig config = new MToastConfig.Builder()
                .setGravity(MToastConfig.MToastGravity.CENTRE)
                .setBackgroundStrokeColor(Color.WHITE)
                .setBackgroundCornerRadius(10)
                .build();
        MToast.makeTextShort(ContextHolder.getContext(), content, config).show();

    }

    /**
     * 开发环境使用
     * @param msg
     */
    public static void showToastOnline(String msg) {
        if (BaseApplication.DEUG) {
            showToast(msg);
        }
    }

}
