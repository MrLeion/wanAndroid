package tzl.com.awesomewanandroid.testExample;

import android.view.View;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.base.WBaseActivity;
import tzl.com.awesomewanandroid.data.api.ApiManager;
import tzl.com.awesomewanandroid.data.pojo.ArticleList;
import tzl.com.framework.helper.ToastHelper;
import tzl.com.framework.net.pojo.BaseResponse;
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

        ApiManager.getApi().getAricle(1)
                .compose(RxSchedulers.<BaseResponse<ArticleList>>applyObservableAsync())
                .subscribe(new Observer<BaseResponse<ArticleList>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResponse<ArticleList> response) {
                        ToastHelper.showToast(response.getData().toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        ToastHelper.showToast(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });



    }

    public void post(View view) {


    }

    public void cookie(View view) {



    }
}
