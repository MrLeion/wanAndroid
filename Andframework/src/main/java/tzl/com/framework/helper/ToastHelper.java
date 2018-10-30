package tzl.com.framework.helper;

import android.graphics.Color;
import android.os.Looper;

import tzl.com.framework.base.BaseApplication;
import tzl.com.framework.widget.toastCompat.PermissonRemoveToastCompat;

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
        try {
//            MToast.makeTextShort(ContextHolder.getContext(), content).show();
            PermissonRemoveToastCompat.makeText(ContextHolder.getContext(),content,PermissonRemoveToastCompat.LENGTH_LONG).show();

        } catch (Exception e) {
            //解决在子线程中调用Toast的异常情况处理
            Looper.prepare();
//            MToast.makeTextShort(ContextHolder.getContext(), content).show();
            PermissonRemoveToastCompat.makeText(ContextHolder.getContext(),content,PermissonRemoveToastCompat.LENGTH_LONG).show();


            Looper.loop();
        }





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
