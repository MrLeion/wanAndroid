package tzl.com.awesomewanandroid.adapter;

import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.Random;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.data.pojo.Topic;
import tzl.com.framework.helper.ContextHolder;
import tzl.com.framework.helper.DensityHelper;
import tzl.com.framework.widget.cardView.ShadowCardView;

/**
 * author: tangzenglei
 * created on: 2018/10/19 下午3:18
 * description:
 */
public class NewsAdapter extends BaseQuickAdapter<Topic,BaseViewHolder> {


    int[] colors = {0xff01a3a1, 0xff91bbeb, 0xff01b1bf, 0xffff9d62, 0xff2d3867, 0xffee697e};//颜色组
    public NewsAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, Topic item) {


        if (!TextUtils.isEmpty(item.title)) {
            helper.setText(R.id.tvTitle,item.title);
        }else{
            helper.setText(R.id.item_home_title, "");
        }

        if (!TextUtils.isEmpty(item.publishDate)) {
            helper.setText(R.id.tvTime,item.publishDate);
        }else{
            helper.setText(R.id.tvTime, "");
        }


        if (!TextUtils.isEmpty(item.summary)) {
            helper.setText(R.id.tvContent,item.summary);
        }else{
            helper.setText(R.id.tvContent, "");
        }


        ShadowCardView shadowCardView = helper.getView(R.id.cardView);
        int index = new Random().nextInt(100) % 5;
        shadowCardView.setShadowColor(colors[index]);
        shadowCardView.setCardBackgroundColor(colors[index]);
        shadowCardView.setCardElevation(DensityHelper.dp2px(ContextHolder.getContext(), 2));
    }
}
