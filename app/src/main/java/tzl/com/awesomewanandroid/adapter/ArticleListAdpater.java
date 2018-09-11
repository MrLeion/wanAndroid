package tzl.com.awesomewanandroid.adapter;

import android.text.Html;
import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.data.pojo.Article;

/**
 * author: tangzenglei
 * created on: 2018/9/10 下午4:26
 * description:首页文章列表
 */
public class ArticleListAdpater extends BaseQuickAdapter<Article,BaseViewHolder> {

    public ArticleListAdpater(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, Article article) {

        if (!TextUtils.isEmpty(article.getTitle())) {
            helper.setText(R.id.item_home_title, Html.fromHtml(article.getTitle()));
        }else{
            helper.setText(R.id.item_home_title, "");

        }
        if (article.isCollect()) {
            helper.setImageResource(R.id.item_home_like_iv, R.drawable.icon_like_article_selected);
        } else {
            helper.setImageResource(R.id.item_home_like_iv, R.drawable.icon_like_article_not_selected);
        }
        if (!TextUtils.isEmpty(article.getAuthor())) {
            helper.setText(R.id.item_home_author, article.getAuthor());
        }
//        setTag(helper, article);
        if (!TextUtils.isEmpty(article.getChapterName())) {
            String classifyName = article.getSuperChapterName() + " / " + article.getChapterName();
//            if (isCollectPage) {
                helper.setText(R.id.item_home_chapterName, article.getChapterName());
//            } else {
//                helper.setText(R.id.item_home_chapterName, classifyName);
//            }
        }
        if (!TextUtils.isEmpty(article.getNiceDate())) {
            helper.setText(R.id.item_home_niceDate, article.getNiceDate());
        }

        helper.addOnClickListener(R.id.item_home_chapterName);
        helper.addOnClickListener(R.id.item_home_like_iv);






    }
}
