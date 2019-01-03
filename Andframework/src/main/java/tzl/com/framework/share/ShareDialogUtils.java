//package tzl.com.framework.share;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.net.Uri;
//import android.provider.MediaStore;
//import android.text.TextUtils;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.umeng.socialize.UMShareAPI;
//import com.umeng.socialize.bean.SHARE_MEDIA;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.lang.ref.SoftReference;
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import tzl.com.framework.R;
//import tzl.com.framework.share.encode.BitmapCompressor;
//import tzl.com.framework.share.view2image.ViewToImageUtil;
//import tzl.com.framework.widget.banner.MZBannerView;
//import tzl.com.framework.widget.banner.ZoomOutPageTransformer;
//import tzl.com.framework.widget.banner.holder.MZHolderCreator;
//import tzl.com.framework.widget.banner.holder.MZViewHolder;
//import tzl.com.framework.widget.dialog.CustomCenterDialog;
//import tzl.com.framework.widget.listener.OnViewClickListener;
//
///**
// * author: tangzenglei
// * created on: 2018/12/17 5:24 PM
// * description: 推广分享弹框
// */
//public class ShareDialogUtils {
//
//    private static SoftReference<Activity> sActivity;
//    private        CustomCenterDialog      mInfoDialog;
//    private        CustomCenterDialog      mShareLinkDialog;
//    private        CustomCenterDialog      mSharePostDialog;
//
//
//    private static ShareDialogUtils  instance;
//    private        UMShareAPI        umShareAPI;
//    private        List<PromoteItem> mBannerList;
//    private int mType =1;
//
//    private ShareDialogUtils() {
//        if (instance != null) {
//            throw new RuntimeException("ShareDialogUtils");
//        }
//    }
//
//    public static ShareDialogUtils getInstance(Activity activity) {
//        sActivity = new SoftReference<>(activity);
//        synchronized (ShareDialogUtils.class) {
//            if (null == instance) {
//                synchronized (ShareDialogUtils.class) {
//                    instance = new ShareDialogUtils();
//                }
//            }
//        }
//        return instance;
//    }
//
//
//
//
//
//    /**
//     * @param promoteType 分享类型
//     * @param produtId    产品id
//     * @param tplType     海报类型
//     */
//    public void share(String promoteType,
//                      String produtId,
//                      int tplType) {
//        Call<PromoteListBeanInfo> proxy = ApiManager.getApi().promoteProxy("20", promoteType, produtId, tplType);
//        proxy.enqueue(new Callback<PromoteListBeanInfo>() {
//            @Override
//            public void onResponse(Call<PromoteListBeanInfo> call, Response<PromoteListBeanInfo> response) {
//                if (response.isSuccessful()) {
//                    PromoteListBeanInfo info = response.body();
//                    if (info.getCode() == 1021) {
//                        if (info.getResult() != null && info.getResult().proxyUrl != null && info.getResult().proxyUrl.startsWith("http")) {
//                            H5Activity.startActivity(sActivity.get(), "", info.getResult().proxyUrl);
//                        }
//                    } else {
//                        if (null != info.getResult()) {
//                            switch (promoteType) {
//                                case AppKey.LINKTYPE:
//                                    showShareLinkDialog(sActivity.get(), info.getResult());
//                                    break;
//                                case AppKey.POSTTYPE:
//                                    switch (tplType) {
//                                        case 1://产品列表模板
//                                            showSharePostDialog(sActivity.get(), TYPE.TUIYOU, info.getResult());
//                                            break;
//                                        case 2://外部产品模板
//                                            showSharePostDialog(sActivity.get(), TYPE.EXTERNAL, info.getResult());
//                                            break;
//                                        case 3://app 推广模板
//                                            showSharePostDialog(sActivity.get(), TYPE.AGENCY, info.getResult());
//                                            break;
//                                    }
//                                    break;
//                            }
//                        } else {
//                            ToastUtil.showToast(info.getErrorMsg());
//                        }
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<PromoteListBeanInfo> call, Throwable t) {
//                //todo noting
//                ToastUtil.showToast("网络连接错误");
//            }
//        });
//    }
//
//
//    /**
//     * 海报分享
//     */
//    public void showSharePostDialog(Activity activity, TYPE type, PromoteListBean promoteListBean) {
//        umShareAPI = UMShareAPI.get(activity);
//        if (mSharePostDialog != null && mSharePostDialog.isShowing()) {
//            return;
//        }
//        View view = LayoutInflater.from(activity).inflate(R.layout.t_dialog_post_layout, null);
//        MZBannerView banner = view.findViewById(R.id.banner);
//        initImageGallery(banner, type, promoteListBean, activity,mType);
//        mSharePostDialog = new CustomCenterDialog.Builder(activity)
//                .view(view)
//                .widthFixed(true)
//                .widthpx((int) sActivity.get().getResources().getDimension(R.dimen.x690))
//                .heigthFixed(true)
//                .heightpx((int) sActivity.get().getResources().getDimension(R.dimen.x1000))
//                .cancelTouchOut(true)
//                .addViewOnclick(R.id.ivPre, new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        preOne(banner);
//                    }
//                })
//                .addViewOnclick(R.id.ivNext, new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        nextOne(banner);
//                    }
//                })
//                .addViewOnclick(R.id.tvSaveQcode, new OnViewClickListener() {
//                    @Override
//                    public void onViewClick(View v) {
//                        saveViewToImage(banner, activity);
//                    }
//                })
//                .addViewOnclick(R.id.tvShareByWechat, new OnViewClickListener() {
//                    @Override
//                    public void onViewClick(View v) {
//                        shareBitmapByWechat(banner, activity);
//                    }
//                })
//                .addViewOnclick(R.id.tvShareByQq, new OnViewClickListener() {
//                    @Override
//                    public void onViewClick(View v) {
//                        shareBitmapByQQ(banner, activity);
//                    }
//                })
//                .style(R.style.ShareDialog)
//                .build();
//        mSharePostDialog.show();
//    }
//
//    /**
//     * 分享
//     *
//     * @param banner
//     * @param activity
//     */
//    private void shareBitmapByQQ(MZBannerView banner, Activity activity) {
//        View view = banner.getViewPager().findViewWithTag(banner.getViewPager().getCurrentItem());
//        Bitmap bitmap = new BitmapCompressor().compressBitmap(ViewToImageUtil.getSimpleView2Bitmap(view));
//        if (umShareAPI.isInstall(activity, SHARE_MEDIA.QQ)) {
//            ShareUtils.shareImage(activity, "送你一次领取现金的机会", null, bitmap, SHARE_MEDIA.QQ, shareSuccessCallback);
//        } else {
//            ToastUtil.showToast("未安装微信，请安装后重试");
//        }
//        mSharePostDialog.dismiss();
//    }
//
//    private void shareBitmapByWechat(MZBannerView banner, Activity activity) {
//        View view = banner.getViewPager().findViewWithTag(banner.getViewPager().getCurrentItem());
//        Bitmap bitmap = new BitmapCompressor().compressBitmap(ViewToImageUtil.getSimpleView2Bitmap(view));
//        if (umShareAPI.isInstall(activity, SHARE_MEDIA.WEIXIN)) {
//            ShareUtils.shareImage(activity, "送你一次领取现金的机会", null, bitmap, SHARE_MEDIA.WEIXIN, shareSuccessCallback);
//        } else {
//            ToastUtil.showToast("未安装微信，请安装后重试");
//        }
//        mSharePostDialog.dismiss();
//    }
//
//    private void saveViewToImage(MZBannerView banner, Context activity) {
//        ViewGroup view = banner.getViewPager().findViewWithTag(banner.getViewPager().getCurrentItem());
//        ViewToImageUtil.generateImage(view, new ViewToImageUtil.OnImageSavedCallback() {
//            @Override
//            public void onFinishCallback(String path) {
//                //将截图保存至相册并广播通知系统刷新
//                try {
//                    MediaStore.Images.Media.insertImage(activity.getContentResolver(), path, "", null);
//                    Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(new File(path)));
//                    activity.sendBroadcast(intent);
//                    ToastUtil.showToast("保存成功至相册");
//                    mSharePostDialog.dismiss();
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//
//    private void nextOne(MZBannerView banner) {
//        int index = banner.getViewPager().getCurrentItem() + 1;
//        if (index > mBannerList.size() - 1) {
//            index = mBannerList.size() - 1;
//        }
//        banner.getViewPager().setCurrentItem(index);
//    }
//
//    private void preOne(MZBannerView banner) {
//        int index = banner.getViewPager().getCurrentItem() - 1;
//        if (index < 0) {
//            index = 0;
//        }
//        banner.getViewPager().setCurrentItem(index);
//    }
//
//
//    /**
//     * 初始化 海报分享界面
//     * @param banner
//     * @param type
//     * @param promoteListBean
//     * @param activity
//     */
//    public void initImageGallery(MZBannerView banner, TYPE type, PromoteListBean promoteListBean, Activity activity, int pos) {
//        banner.setIndicatorVisible(true);
//        banner.setIndicatorAlign(MZBannerView.IndicatorAlign.CENTER);
//        banner.setIndicatorRes(R.mipmap.t_ic_indicator_normal, R.mipmap.t_ic_indicator_selected);
//        mBannerList = promoteListBean.promoteTpl;
//        banner.setPages(mBannerList, new MZHolderCreator() {
//            @Override
//            public MZViewHolder createViewHolder() {
//                switch (type) {
//                    case EXTERNAL:
//                        return new ExternalProductViewHolder(promoteListBean, activity);
//                    case AGENCY:
//                        return new AgencyViewHolder(promoteListBean, activity);
//                    case TUIYOU:
//                    default:
//                        return new TuiYouProductViewHolder(promoteListBean, activity,pos);
//                }
//            }
//        });
//        //改变 viewpager transform
//        banner.getViewPager().setPageTransformer(true, new ZoomOutPageTransformer());
//    }
//
//
//    /**
//     * 链接分享
//     */
//    public void showShareLinkDialog(Activity activity, PromoteListBean promoteListBean) {
//        umShareAPI = UMShareAPI.get(activity);
//        if (mShareLinkDialog != null && mShareLinkDialog.isShowing()) {
//            return;
//        }
//        View view = LayoutInflater.from(activity).inflate(R.layout.t_dialog_link_layout, null);
//        TextView tvPostUrl = view.findViewById(R.id.tvPostUrl);
//        initView(promoteListBean, view, tvPostUrl);
//        tvPostUrl.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                copy(tvPostUrl, activity);
//                mShareLinkDialog.dismiss();
//                return false;
//            }
//        });
//        tvPostUrl.setOnClickListener(new OnViewClickListener() {
//            @Override
//            public void onViewClick(View v) {
//                copy(tvPostUrl, activity);
//            }
//        });
//
//        mShareLinkDialog = new CustomCenterDialog.Builder(activity)
//                .view(view)
//                .widthFixed(true)
//                .widthpx((int) sActivity.get().getResources().getDimension(R.dimen.x690))
//                .heigthFixed(true)
//                .heightpx((int) sActivity.get().getResources().getDimension(R.dimen.x540))
//                .cancelTouchOut(true)
//                .addViewOnclick(R.id.tvCopyLink, new OnViewClickListener() {
//                    @Override
//                    public void onViewClick(View v) {
//                        copyLink(tvPostUrl, activity);
//
//                    }
//                })
//                .addViewOnclick(R.id.tvWechat, new OnViewClickListener() {
//                    @Override
//                    public void onViewClick(View v) {
//                        shareLinkToWechat(tvPostUrl, activity, promoteListBean);
//                    }
//                })
//                .addViewOnclick(R.id.tvQQ, new OnViewClickListener() {
//                    @Override
//                    public void onViewClick(View v) {
//                        shareLinkToQQ(tvPostUrl, activity, promoteListBean, SHARE_MEDIA.QQ, "未安装QQ，请安装后重试");
//                    }
//                })
//                .style(R.style.ShareDialog)
//                .build();
//        mShareLinkDialog.show();
//    }
//
//    private void copy(TextView tvPostUrl, Context activity) {
//        String postUrl = tvPostUrl.getText().toString().trim();
//        ClipUtils.copy(postUrl, activity);
//        ToastUtil.showToast("复制成功");
//    }
//
//    private void copyLink(TextView tvPostUrl, Context activity) {
//        String postUrl = tvPostUrl.getText().toString().trim();
//        ClipUtils.copy(postUrl, activity);
//        ToastUtil.showToast("复制成功");
//        mShareLinkDialog.dismiss();
//    }
//
//    private void initView(PromoteListBean promoteListBean, View view, TextView tvPostUrl) {
//        ImageView ivProductLogo = view.findViewById(R.id.ivProductLogo);
//        TextView tvProductName = view.findViewById(R.id.tvProductName);
//
//        if (promoteListBean.productModel != null) {
//            PromoteListBean.ProductModelBean productModel = promoteListBean.productModel;
//            if (!TextUtils.isEmpty(productModel.getName())) {
//                tvProductName.setText(productModel.getName());
//            } else {
//                tvProductName.setText("");
//            }
//            if (!TextUtils.isEmpty(productModel.getLogo())) {
//                ImageLoader.loadRoundImage(ivProductLogo, productModel.getLogo(), R.mipmap.ic_default_product_logo, sActivity.get().getResources().getDimensionPixelOffset(R.dimen.x4));
////                ImageLoader.loadImg(ivProductLogo, productModel.getLogo());
//            }
//        }
//
//        if (!TextUtils.isEmpty(promoteListBean.posterUrl)) {
//            tvPostUrl.setText(promoteListBean.posterUrl+(promoteListBean.posterUrl.contains("?")?"&type="+mType:"?type="+mType));
//        } else {
//            tvPostUrl.setText("");
//        }
//    }
//
//
//    /**
//     * * 分享链接到 qq
//     *
//     * @param tvPostUrl
//     * @param activity
//     * @param promoteListBean
//     * @param qq
//     * @param tips
//     */
//    private void shareLinkToQQ(TextView tvPostUrl, Activity activity, PromoteListBean promoteListBean, SHARE_MEDIA qq, String tips) {
//        String postUrl = tvPostUrl.getText().toString().trim();
//        if (TextUtils.isEmpty(postUrl) || !postUrl.startsWith("http")) {
//            ToastUtil.showToast("分享链接无效");
//            return;
//        }
//        if (umShareAPI.isInstall(activity, qq)) {
//            PromoteListBean.ProductModelBean productModel = promoteListBean.productModel;
//            if (productModel != null) {
//                ShareUtils.shareWeb(activity, postUrl, productModel.getShareTitle(), productModel.getShareContent(), promoteListBean.productModel.getLogo(), R.mipmap.ic_default_product_logo, qq, shareSuccessCallback);
//            } else {
//                ShareUtils.shareWeb(activity, postUrl, "送你一次领取现金的机会", "快来领取吧！", promoteListBean.productModel.getLogo(), R.mipmap.ic_default_product_logo, qq, shareSuccessCallback);
//            }
//        } else {
//            ToastUtil.showToast(tips);
//        }
//        mShareLinkDialog.dismiss();
//    }
//
//    /**
//     * 分享链接到 微信
//     *
//     * @param tvPostUrl
//     * @param activity
//     * @param promoteListBean
//     */
//    private void shareLinkToWechat(TextView tvPostUrl, Activity activity, PromoteListBean promoteListBean) {
//        String postUrl = tvPostUrl.getText().toString().trim();
//        if (TextUtils.isEmpty(postUrl) || !postUrl.startsWith("http")) {
//            ToastUtil.showToast("分享链接无效");
//            return;
//        }
//        if (umShareAPI.isInstall(activity, SHARE_MEDIA.WEIXIN)) {
//
//            PromoteListBean.ProductModelBean productModel = promoteListBean.productModel;
//            if (productModel != null) {
//                ShareUtils.shareWeb(activity, postUrl, productModel.getShareTitle(), productModel.getShareContent(), promoteListBean.productModel.getLogo(), R.mipmap.ic_default_product_logo, SHARE_MEDIA.WEIXIN, shareSuccessCallback);
//            } else {
//                ShareUtils.shareWeb(activity, postUrl, "送你一次领取现金的机会", "快来领取吧！", promoteListBean.productModel.getLogo(), R.mipmap.ic_default_product_logo, SHARE_MEDIA.WEIXIN, shareSuccessCallback);
//            }
//
//        } else {
//            ToastUtil.showToast("未安装微信，请安装后重试");
//        }
//
//        mShareLinkDialog.dismiss();
//    }
//
//
//    private ShareUtils.ShareSuccessCallback shareSuccessCallback = new ShareUtils.ShareSuccessCallback() {
//        @Override
//        public void onShareSuccess(SHARE_MEDIA share_media) {
//        }
//
//        @Override
//        public void onShareReturn(SHARE_MEDIA share_media, int type) {
//
//        }
//    };
//
//
//    /**
//     * 提交信息弹框
//     *
//     * @param activity
//     */
//    public void showInfoDialog(Activity activity, InfoCallback callback) {
//        if (mInfoDialog != null && mInfoDialog.isShowing()) {
//            return;
//        }
//        View view = LayoutInflater.from(activity).inflate(R.layout.t_dialog_baseinfo_layout, null);
//        mInfoDialog = new CustomCenterDialog.Builder(activity)
//                .view(view)
//                .widthFixed(true)
//                .widthpx((int) sActivity.get().getResources().getDimension(R.dimen.x600))
//                .heigthFixed(true)
//                .heightpx((int) sActivity.get().getResources().getDimension(R.dimen.x711))
//                .cancelTouchOut(true)
//                .addViewOnclick(R.id.btn_confirm, new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        EditText etName = view.findViewById(R.id.etName);
//                        EditText etPhone = view.findViewById(R.id.etPhone);
//                        String name = etName.getText().toString().trim();
//                        String phone = etPhone.getText().toString().trim();
//                        if (TextUtils.isEmpty(name)) {
//                            ToastUtil.showToast("请输入姓名");
//                            return;
//                        }
//                        if (TextUtils.isEmpty(phone)) {
//                            ToastUtil.showToast("请输入手机号");
//                            return;
//                        }
//                        //校验手机号
//                        if (!RegularUtil.isPhone(phone)) {
//                            ToastUtil.showToast("请输入十一位手机号");
//                            return;
//                        }
//                        //提交信息
//                        if (callback != null) {
//                            callback.onSubmit(name, phone);
//                        }
//                    }
//                })
//                .style(R.style.ShareDialog)
//                .build();
//
//        mInfoDialog.show();
//    }
//
//
//    /**
//     * 提交信息弹框
//     */
//    public void dimissInfoDialog() {
//        if (mInfoDialog != null && mInfoDialog.isShowing()) {
//            mInfoDialog.dismiss();
//        }
//    }
//
//
//    /**
//     * 给 H5 传值，设置对应 tab
//     * @param position
//     */
//    public void setPosition(int position) {
//
//        mType = position;
//
//    }
//
//
//    public interface InfoCallback {
//
//        void onSubmit(String name, String phone);
//
//    }
//
//
//    public enum TYPE {
//        TUIYOU,
//        EXTERNAL,
//        AGENCY
//    }
//
//}
