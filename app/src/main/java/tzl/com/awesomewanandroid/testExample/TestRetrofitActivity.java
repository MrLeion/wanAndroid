package tzl.com.awesomewanandroid.testExample;

import android.view.View;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.base.WBaseActivity;
import tzl.com.awesomewanandroid.data.api.ApiManager;
import tzl.com.awesomewanandroid.data.pojo.ArticleList;
import tzl.com.framework.helper.ToastHelper;
import tzl.com.framework.net.pojo.BaseResponse;
import tzl.com.framework.rx.BaseObserver;
import tzl.com.framework.rx.RxSchedulers;

public class TestRetrofitActivity extends WBaseActivity {



    @Override
    public int getLayoutId() {
        return R.layout.activity_test_retrofit;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initData() {

    }


    public void get(View view) {
        ApiManager.getWanAndroidApi().getAricle(1)
                .compose(RxSchedulers.<BaseResponse<ArticleList>>applyObservableAsync())
                .subscribe(new BaseObserver<ArticleList>() {
                    @Override
                    public void onSuccess(BaseResponse<ArticleList> response) {
                        ToastHelper.showToast(response.getData().toString());
                    }

                    @Override
                    public void onFailure(BaseResponse<ArticleList> response) {
                        ToastHelper.showToast(response.getData().toString());
                    }
                });
    }

    public void post(View view) {
        ApiManager.getWanAndroidApi().login("MrLeion","abc123")
                .compose( RxSchedulers.<BaseResponse<Object>>applyObservableAsync())
                .subscribe(new BaseObserver<Object>(TestRetrofitActivity.this,true) {
                    @Override
                    public void onSuccess(BaseResponse<Object> response) {
                        ToastHelper.showToast(response.getData().toString());
                    }

                    @Override
                    public void onFailure(BaseResponse<Object> response) {
                        ToastHelper.showToast(response.getErrorMsg());
                    }
                });
    }

    public void cookie(View view) {














    }
}
