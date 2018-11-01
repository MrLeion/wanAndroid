package tzl.com.awesomewanandroid.ui.navigator;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import butterknife.BindView;
import tzl.com.awesomewanandroid.MainActivity;
import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.base.WBaseFragment;
import tzl.com.framework.widget.multistatusview.MultipleStatusView;

/**
 * author: tangzenglei
 * created on: 2018/8/27 下午4:00
 * description:体系
 */
public class NavigatorFragment extends WBaseFragment<NavigatorPresenter> implements NavigatorView {


    @BindView(R.id.indexRecyclerView)
    RecyclerView       mIndexRecyclerView;
    @BindView(R.id.contentRecyclerView)
    RecyclerView       mContentRecyclerView;
    @BindView(R.id.multistatusview)
    MultipleStatusView mMultistatusview;

    public static NavigatorFragment newInstance(String title) {
        NavigatorFragment fragment = new NavigatorFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_navigator;
    }

    @Override
    public void initView() {
        ((MainActivity)getActivity()).setOnDispatchTouchListener(new MainActivity.OnDispatchTouchListener() {
            @Override
            public boolean onDispatchTouchEvent(MotionEvent ev) {



                /**
                 *多点触碰的时候 不触发任何事件
                 */
                if (ev.getPointerCount()>2) {
                    return true;
                }
                /**
                 * 如果左侧的RecyclerView1在滚动中，但是此时用户又在RecyclerView2中触发滚动事件，则停止所有滚动，等待新一轮滚动。
                 * 如果右侧的RecyclerView2在滚动中，但是此时用户又在RecyclerView1中触发滚动事件，则停止所有滚动，等待新一轮滚动。
                 *
                 */
                if (mIndexRecyclerView.getScrollState() != RecyclerView.SCROLL_STATE_IDLE||mContentRecyclerView.getScrollState() != RecyclerView.SCROLL_STATE_IDLE) {
                    if (isTouchEventInView(mContentRecyclerView, ev.getX(), ev.getY())||isTouchEventInView(mIndexRecyclerView, ev.getX(), ev.getY())) {
                        mIndexRecyclerView.stopScroll();
                        mContentRecyclerView.stopScroll();
                        return true;
                    }
                }
                return false;

            }
        });

    }


    /**
     * 判断触碰位置是否在某个空间范围内
     * @param view
     * @param x
     * @param y
     * @return
     */
    private boolean isTouchEventInView(View view, float x, float y) {
        if (view == null) {
            return false;
        }

        int[] location = new int[2];
        view.getLocationOnScreen(location);

        int left = location[0];
        int top = location[1];

        int right = left + view.getMeasuredWidth();
        int bottom = top + view.getMeasuredHeight();

        if (y >= top && y <= bottom && x >= left && x <= right) {
            return true;
        }

        return false;
    }


    @Override
    public void initEvent() {
        mIndexRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (recyclerView.getScrollState() != RecyclerView.SCROLL_STATE_IDLE) {
                    mContentRecyclerView.scrollBy(dx, dy);
                }
            }
        });

        mContentRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (recyclerView.getScrollState() != RecyclerView.SCROLL_STATE_IDLE) {
                    mIndexRecyclerView.scrollBy(dx, dy);
                }
            }
            });
    }

    @Override
    public void initData() {
        mPresenter = new NavigatorPresenter(this, new NavigatorModel());
        mPresenter.loadData();
    }


    public RecyclerView getIndexRecyclerView() {
        return mIndexRecyclerView;
    }

    public RecyclerView getContentRecyclerView() {
        return mContentRecyclerView;
    }


    public MultipleStatusView getMultistatusview() {
        return mMultistatusview;
    }



}
