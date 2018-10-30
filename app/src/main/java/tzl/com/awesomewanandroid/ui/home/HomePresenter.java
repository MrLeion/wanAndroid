package tzl.com.awesomewanandroid.ui.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.adapter.ArticleListAdpater;
import tzl.com.awesomewanandroid.data.pojo.Article;
import tzl.com.awesomewanandroid.data.pojo.ArticleList;
import tzl.com.awesomewanandroid.data.pojo.Banner;
import tzl.com.awesomewanandroid.ui.h5.JumpUtils;
import tzl.com.awesomewanandroid.widget.GlideImageLoader;
import tzl.com.framework.base.BasePresenter;
import tzl.com.framework.helper.ToastHelper;
import tzl.com.framework.net.pojo.BaseResponse;
import tzl.com.framework.rx.BaseObserver;
import tzl.com.framework.rx.RxSchedulers;

/**
 * author: tangzenglei
 * created on: 2018/9/6 上午9:32
 * description:
 */
public class HomePresenter extends BasePresenter<HomeView,HomeModel> {


    private RecyclerView            mRecyclerView;
    private SmartRefreshLayout      mRefreshLayout;
    private View                    mHeader;
    private ArticleListAdpater      mArticleListAdpater;
    private com.youth.banner.Banner mBanner;

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
        mBanner = mHeader.findViewById(R.id.banner);
        mBanner.setImageLoader(new GlideImageLoader());
        mArticleListAdpater = new ArticleListAdpater(R.layout.item_article_list);
        mArticleListAdpater.addHeaderView(mHeader);
        mRecyclerView.setAdapter(mArticleListAdpater);
        mArticleListAdpater.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Article article = (Article) adapter.getItem(position);
                JumpUtils.startH5(mActivity,article.getLink());
            }
        });
    }

    @Override
    public void registerEvent() {
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                getBanner();
                getArticle();
            }
        });
    }

    public void getBanner() {
        mModel.getBanner()
                .compose(RxSchedulers.<BaseResponse<List<Banner>>>applyObservableAsync())
                .subscribe(new BaseObserver<List<Banner>>() {
                    @Override
                    public void onSuccess(BaseResponse<List<Banner>> response) {
                        if (null!=mRefreshLayout&&mRefreshLayout.isRefreshing()) {
                            mRefreshLayout.finishRefresh();
                        }
                        if (response.getData()!=null) {
                            ArrayList<String> imgUrls = new ArrayList<>();
                            for (int i = 0; i < response.getData().size(); i++) {
                                imgUrls.add(response.getData().get(i).getImagePath());
                            }
                            mBanner.setImages(imgUrls).start();
                        }
                    }

                    @Override
                    public void onFailure(BaseResponse<List<Banner>> response) {
                        if (null!=mRefreshLayout&&mRefreshLayout.isRefreshing()) {
                            mRefreshLayout.finishRefresh();
                        }
                        ToastHelper.showToast(response.getErrorMsg());
                    }
                });

    }

    public void getArticle() {

        mModel.getAricle(0)
                .compose(RxSchedulers.<BaseResponse<ArticleList>>applyObservableAsync())
                .subscribe(new BaseObserver<ArticleList>() {
                    @Override
                    public void onSuccess(BaseResponse<ArticleList> response) {
                        if (null!=mRefreshLayout&&mRefreshLayout.isRefreshing()) {
                            mRefreshLayout.finishRefresh();
                        }
                        if (response.getData()!=null
                                &&response.getData().getDatas()!=null
                                &&response.getData().getDatas().size()>0) {
                            mArticleListAdpater.setNewData(response.getData().getDatas());
                        }
                    }

                    @Override
                    public void onFailure(BaseResponse<ArticleList> response) {
                        if (null!=mRefreshLayout&&mRefreshLayout.isRefreshing()) {
                            mRefreshLayout.finishRefresh();
                        }
                        ToastHelper.showToast(response.getErrorMsg());
                    }
                });
    }
}
