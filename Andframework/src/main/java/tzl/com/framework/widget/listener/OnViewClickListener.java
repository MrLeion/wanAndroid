package tzl.com.framework.widget.listener;

import android.view.View;

/**
 * author: tangzenglei
 * created on: 2018/10/19 下午5:24
 * description: //记录点击时间，避免重复点击
 * https://www.jianshu.com/p/28751130c038
 */
public abstract class OnViewClickListener implements View.OnClickListener {


    private long LastTime = System.currentTimeMillis();

    @Override
    public void onClick(View v) {
        //TODO 记录点击事件
        if ( System.currentTimeMillis()-LastTime>500) {
            onViewOnClick(v);
        }
    }

    public abstract void onViewOnClick(View v);
}
