package tzl.com.awesomewanandroid.adapter;

import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.data.pojo.NaviJson;

/**
 * author: tangzenglei
 * created on: 2018/10/19 下午3:18
 * description:
 */
public class IndexNavigatorAdapter extends BaseQuickAdapter<NaviJson,BaseViewHolder> {


    public IndexNavigatorAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, NaviJson item) {


        if (!TextUtils.isEmpty(item.getName())) {
            helper.setText(R.id.tvIndex,item.getName());
        }else{
            helper.setText(R.id.tvIndex, "");
        }



    }
}
