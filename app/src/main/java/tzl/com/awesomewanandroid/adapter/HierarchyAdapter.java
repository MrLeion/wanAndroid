package tzl.com.awesomewanandroid.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.data.pojo.ProjectTree;
import tzl.com.framework.helper.DensityHelper;

/**
 * author: tangzenglei
 * created on: 2018/10/19 下午3:18
 * description:
 */
public class HierarchyAdapter extends BaseQuickAdapter<ProjectTree,BaseViewHolder> {


    private final Activity mContext;
    private final int      width;

    public HierarchyAdapter(int layoutResId, Context context) {
        super(layoutResId);
        mContext = (Activity) context;
        width = (int) (DensityHelper.getWidth(mContext) / 3);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProjectTree item) {


        TextView textView = helper.getView(R.id.tvName);
        textView.setWidth(width);
        textView.setHeight(width);


        if (!TextUtils.isEmpty(item.getName())) {
            helper.setText(R.id.tvName,item.getName());
        }else{
            helper.setText(R.id.tvName, "");
        }

    }
}
