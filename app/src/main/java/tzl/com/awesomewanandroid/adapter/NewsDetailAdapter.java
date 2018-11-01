package tzl.com.awesomewanandroid.adapter;

import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.data.pojo.TopicDetail;

/**
 * author: tangzenglei
 * created on: 2018/10/19 下午3:18
 * description: 新闻详情
 */
public class NewsDetailAdapter extends BaseQuickAdapter<TopicDetail.NewsArrayBean,BaseViewHolder> {


    public NewsDetailAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, TopicDetail.NewsArrayBean item) {
        if (!TextUtils.isEmpty(item.getTitle())) {
            helper.setText(R.id.tvTitle,item.getTitle());
        }else{
            helper.setText(R.id.tvTitle, "");
        }
        if (!TextUtils.isEmpty(item.getPublishDate())) {
            helper.setText(R.id.tvTime,item.getPublishDate());
        }else{
            helper.setText(R.id.tvTime, "");
        }

    }
}
