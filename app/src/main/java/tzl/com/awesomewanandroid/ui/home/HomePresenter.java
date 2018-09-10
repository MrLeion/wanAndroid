package tzl.com.awesomewanandroid.ui.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.data.pojo.ArticleList;
import tzl.com.awesomewanandroid.data.pojo.Banner;
import tzl.com.framework.base.BasePresenter;
import tzl.com.framework.net.pojo.BaseResponse;
import tzl.com.framework.rx.BaseObserver;
import tzl.com.framework.rx.RxSchedulers;

/**
 * author: tangzenglei
 * created on: 2018/9/6 上午9:32
 * description:
 */
public class HomePresenter extends BasePresenter<HomeView,HomeModel> {


    private RecyclerView mRecyclerView;
    private SmartRefreshLayout mRefreshLayout;
    private View mHeader;

    /**
     * 绑定 View 和 model
     * @param view
     * @param model
     */
    public HomePresenter(HomeView view, HomeModel model) {
        super(view, model);
    }

    @Override
    public void init() {
        mRecyclerView = mView.getRecyclerView();
        mRefreshLayout = mView.getRefreshLayout();
        mHeader = View.inflate(mActivity, R.layout.view_head_banner, null);
    }

    @Override
    public void registerEvent() {



    }

    public void getBanner() {

        mModel.getBanner()
                .compose(RxSchedulers.<BaseResponse<Banner>>applyObservableAsync())
                .subscribe(new BaseObserver<Banner>() {
                    @Override
                    public void onSuccess(BaseResponse<Banner> response) {
                        if (response.getData()!=null) {
                            


                        }
                    }

                    @Override
                    public void onFailure(BaseResponse<Banner> response) {

                    }
                });








    }

    public void getArticle() {

        mModel.getAricle(0)
                .compose(RxSchedulers.<BaseResponse<ArticleList>>applyObservableAsync())
                .subscribe(new BaseObserver<ArticleList>() {
                    @Override
                    public void onSuccess(BaseResponse<ArticleList> response) {

                    }

                    @Override
                    public void onFailure(BaseResponse<ArticleList> response) {

                    }
                });
    }
}