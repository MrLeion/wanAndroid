package tzl.com.awesomewanandroid.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.data.pojo.Article;
import tzl.com.awesomewanandroid.data.pojo.NaviJson;
import tzl.com.awesomewanandroid.ui.h5.JumpUtils;
import tzl.com.framework.widget.flowLayout.FlowLayout;
import tzl.com.framework.widget.flowLayout.TagAdapter;
import tzl.com.framework.widget.flowLayout.TagFlowLayout;

/**
 * author: tangzenglei
 * created on: 2018/10/19 下午3:18
 * description:
 */
public class ContentNavigatorAdapter extends BaseQuickAdapter<NaviJson, BaseViewHolder> {


    private final Context mContext;

    public ContentNavigatorAdapter(int layoutResId, Context context) {
        super(layoutResId);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, NaviJson item) {


        if (!TextUtils.isEmpty(item.getName())) {
            helper.setText(R.id.tvTitle, item.getName());
        } else {
            helper.setText(R.id.tvTitle, "");
        }
        if (null != item.getArticles() && item.getArticles().size() > 0) {
            TagFlowLayout tflContent = helper.getView(R.id.tflContent);
            tflContent.setAdapter(new TagAdapter<Article>(item.getArticles()) {
                @Override
                public View getView(FlowLayout parent, int position, Article article) {
                    TextView tv = (TextView) LayoutInflater.from(mContext).inflate(R.layout.item_tag,
                            tflContent, false);
                    tv.setText(article.getTitle());
                    return tv;
                }
            });


            tflContent.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
                @Override
                public boolean onTagClick(View view, int position, TagAdapter adapter) {
                    Article article = (Article) adapter.getItem(position);
                    JumpUtils.startH5(mContext, article.getLink());
                    return true;
                }
            });
        }

    }
}
