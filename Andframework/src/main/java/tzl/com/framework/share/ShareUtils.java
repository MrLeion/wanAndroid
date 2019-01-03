package tzl.com.framework.share;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.lang.ref.WeakReference;

import tzl.com.framework.helper.LogHelper;
import tzl.com.framework.helper.ToastHelper;

/**
 * 分享
 */
public class ShareUtils {



    public static int TYPE_RESULT = 1;
    public static int TYPE_ERROR = 2;
    public static int TYPE_CANCEL = 3;

    /**
     * 分享成功的回调
     */
    public interface ShareSuccessCallback {
        void onShareSuccess(SHARE_MEDIA share_media);
        void onShareReturn(SHARE_MEDIA share_media, int type);
    }







    /**
     * 分享链接
     */
    public static void shareWeb(final Activity activity, String webUrl, String title, String description, String imageUrl, int imageId, SHARE_MEDIA platform, ShareSuccessCallback callback) {

        WeakReference<Activity> mActivity = new WeakReference<Activity>(activity);
        UMWeb web = new UMWeb(webUrl);//连接地址
        web.setTitle(title);//标题
        web.setDescription(description);//描述
        if (TextUtils.isEmpty(imageUrl)) {
            web.setThumb(new UMImage(mActivity.get(), imageId));  //本地缩略图
        } else {
            web.setThumb(new UMImage(mActivity.get(), imageUrl));  //网络缩略图
        }
        new ShareAction(activity)
                .setPlatform(platform)
                .withText(description+" "+webUrl)
                .withMedia(web)
                .setCallback(new UMShareListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {
                    }

                    @Override
                    public void onResult(final SHARE_MEDIA share_media) {
                        callback.onShareReturn(share_media, TYPE_RESULT);
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (share_media.name().equals("WEIXIN_FAVORITE")) {
                                    ToastHelper.showToast("收藏成功");
                                } else {
                                    ToastHelper.showToast("分享成功");
                                }
                                //分享成功暴露外部
                                callback.onShareSuccess(share_media);
                            }
                        });
                    }

                    @Override
                    public void onError(final SHARE_MEDIA share_media, final Throwable throwable) {
                        callback.onShareReturn(share_media, TYPE_ERROR);
                        if (throwable != null) {
                           LogHelper.d("throw", "throw:" + throwable.getMessage());
                        }
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ToastHelper.showToast("分享失败");
                            }
                        });
                    }

                    @Override
                    public void onCancel(final SHARE_MEDIA share_media) {
                        callback.onShareReturn(share_media, TYPE_CANCEL);
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ToastHelper.showToast("分享取消");
                            }
                        });
                    }
                })
                .share();

        //新浪微博中图文+链接
        /*new ShareAction(activity)
                .setPlatform(platform)
                .withText(description + " " + WebUrl)
                .withMedia(new UMImage(activity,imageID))
                .share();*/
    }


    /**
     * 分享图片
     * @param activity
     * @param content
     * @param imageUrl
     * @param bitmap
     * @param platform
     * @param callback
     */
    public static void shareImage(final Activity activity, String content, String imageUrl, Bitmap bitmap, SHARE_MEDIA platform, ShareSuccessCallback callback) {

        WeakReference<Activity> mActivity = new WeakReference<>(activity);
        UMImage image;
        if (!TextUtils.isEmpty(imageUrl)) {
            image = new UMImage(mActivity.get(), imageUrl);//网络图片
        } else {
            image = new UMImage(mActivity.get(), bitmap);//bitmap文件
        }
        image.compressStyle = UMImage.CompressStyle.QUALITY; //质量压缩，适合长图的分享
        new ShareAction(activity)
                .setPlatform(platform)
                .withText(content)
                .withMedia(image)
                .setCallback(new UMShareListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {
                    }

                    @Override
                    public void onResult(final SHARE_MEDIA share_media) {
                        callback.onShareReturn(share_media, TYPE_RESULT);
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (share_media.name().equals("WEIXIN_FAVORITE")) {
                                    ToastHelper.showToast("收藏成功");
                                } else {
                                    ToastHelper.showToast("分享成功");
                                }
                                //分享成功暴露外部
                                callback.onShareSuccess(share_media);
                            }
                        });
                    }

                    @Override
                    public void onError(final SHARE_MEDIA share_media, final Throwable throwable) {
                        callback.onShareReturn(share_media, TYPE_ERROR);
                        if (throwable != null) {
                           LogHelper.d("throw", "throw:" + throwable.getMessage());
                        }
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ToastHelper.showToast("分享失败");
                            }
                        });
                    }

                    @Override
                    public void onCancel(final SHARE_MEDIA share_media) {
                        callback.onShareReturn(share_media, TYPE_CANCEL);
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ToastHelper.showToast("分享取消");
                            }
                        });
                    }
                })
                .share();

        //新浪微博中图文+链接
        /*new ShareAction(activity)
                .setPlatform(platform)
                .withText(description + " " + WebUrl)
                .withMedia(new UMImage(activity,imageID))
                .share();*/
    }




}