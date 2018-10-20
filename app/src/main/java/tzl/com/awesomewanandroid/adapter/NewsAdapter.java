package tzl.com.awesomewanandroid.adapter;

import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.data.pojo.Topic;

/**
 * author: tangzenglei
 * created on: 2018/10/19 下午3:18
 * description:
 */
public class NewsAdapter extends BaseQuickAdapter<Topic,BaseViewHolder> {
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





    }
}
