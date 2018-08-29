package tzl.com.awesomewanandroid.adapter;

import android.text.TextUtils;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.data.pojo.ProjectList;
import tzl.com.awesomewanandroid.holder.ProjectListHolder;
import tzl.com.framework.glide.GlideImageLoader;

/**
 * author: tangzenglei
 * created on: 2018/8/28 下午5:15
 * description: 项目列表
 */
public class ProjectListAdapter extends BaseQuickAdapter<ProjectList.DatasBean,ProjectListHolder> {


    public ProjectListAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(ProjectListHolder helper, ProjectList.DatasBean item) {


        if (!TextUtils.isEmpty(item.getEnvelopePic())) {
            GlideImageLoader.loadImage(mContext, (ImageView) helper.getView(R.id.item_project_list_iv), item.getEnvelopePic(),R.mipmap.ic_launcher,R.mipmap.ic_launcher);
        }
        if (!TextUtils.isEmpty(item.getTitle())) {
            helper.setText(R.id.item_project_list_title_tv, item.getTitle());
        }else{
            helper.setText(R.id.item_project_list_title_tv,"");
        }
        if (!TextUtils.isEmpty(item.getDesc())) {
            helper.setText(R.id.item_project_list_content_tv, item.getDesc());
        }else{
            helper.setText(R.id.item_project_list_content_tv,"");

        }
        if (!TextUtils.isEmpty(item.getNiceDate())) {
            helper.setText(R.id.item_project_list_time_tv, item.getNiceDate());
        }else{
            helper.setText(R.id.item_project_list_time_tv, "");
        }
        if (!TextUtils.isEmpty(item.getAuthor())) {
            helper.setText(R.id.item_project_list_author_tv, item.getAuthor());
        }else{
            helper.setText(R.id.item_project_list_author_tv, "");
        }



    }
}
