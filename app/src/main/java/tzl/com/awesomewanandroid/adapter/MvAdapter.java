package tzl.com.awesomewanandroid.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.widget.CoverVideo;

/**
 * author: tangzenglei
 * created on: 2018/8/28 下午5:15
 * description: MV 列表
 */
public class MvAdapter extends BaseQuickAdapter<String,BaseViewHolder> {


    private final ImageView coverImageView;
    private final GSYVideoOptionBuilder gsyVideoOptionBuilder;
    private final Activity mActivity;

    public MvAdapter(int layoutResId, Activity activity) {
        super(layoutResId);
        mActivity = activity;
        coverImageView = new ImageView(activity);
        gsyVideoOptionBuilder = new GSYVideoOptionBuilder();
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        String url;
        String title;
        int adapterPosition = helper.getAdapterPosition();
        if (adapterPosition%2 == 0) {
            url = "https://res.exexm.com/cw_145225549855002";
            title = "A man";
            coverImageView.setImageResource(R.mipmap.ic_left);
        }else{
            url = "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4";
            title = "A woman";
            coverImageView.setImageResource(R.mipmap.ic_drawer);
        }
        if (coverImageView.getParent() != null) {
            ViewGroup viewGroup = (ViewGroup) coverImageView.getParent();
            viewGroup.removeView(coverImageView);
        }
        CoverVideo video = helper.getView(R.id.cover);
        //防止错位，离开释放
        //gsyVideoPlayer.initUIState();
        gsyVideoOptionBuilder
                .setIsTouchWiget(false)
                .setThumbImageView(coverImageView)
                .setUrl(url)
                .setSetUpLazy(true)//lazy可以防止滑动卡顿
                .setVideoTitle(title)
                .setCacheWithPlay(true)
                .setRotateViewAuto(true)
                .setLockLand(true)
                .setPlayTag(TAG)
                .setShowFullAnimation(true)
                .setNeedLockFull(true)
                .setPlayPosition(adapterPosition)
                .setVideoAllCallBack(new GSYSampleCallBack() {
                    @Override
                    public void onPrepared(String url, Object... objects) {
                        super.onPrepared(url, objects);
                        if (!video.isIfCurrentIsFullscreen()) {
                            //静音
                            GSYVideoManager.instance().setNeedMute(true);
                        }
                    }

                    @Override
                    public void onQuitFullscreen(String url, Object... objects) {
                        super.onQuitFullscreen(url, objects);
                        //全屏不静音
                        GSYVideoManager.instance().setNeedMute(true);
                    }

                    @Override
                    public void onEnterFullscreen(String url, Object... objects) {
                        super.onEnterFullscreen(url, objects);
                        GSYVideoManager.instance().setNeedMute(false);
                        video.getCurrentPlayer().getTitleTextView().setText((String)objects[0]);
                    }
                }).build(video);

        //增加title
        video.getTitleTextView().setVisibility(View.GONE);

        //设置返回键
        video.getBackButton().setVisibility(View.GONE);

        //设置全屏按键功能
        video.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                video.startWindowFullscreen(mActivity, true, true);
            }
        });


    }
}
