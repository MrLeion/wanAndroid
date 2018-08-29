package tzl.com.awesomewanandroid.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import tzl.com.awesomewanandroid.R;

/**
 * author: tangzenglei
 * created on: 2018/8/29 下午2:43
 * description:
 */
public class ProjectListHolder extends BaseViewHolder {



    @BindView(R.id.item_project_list_iv)
    ImageView mItemProjectListIv;
    @BindView(R.id.item_project_list_title_tv)
    TextView  mItemProjectListTitleTv;
    @BindView(R.id.item_project_list_content_tv)
    TextView  mItemProjectListContentTv;
    @BindView(R.id.item_project_list_time_tv)
    TextView  mItemProjectListTimeTv;
    @BindView(R.id.item_project_list_author_tv)
    TextView  mItemProjectListAuthorTv;

    public ProjectListHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);

    }
}
