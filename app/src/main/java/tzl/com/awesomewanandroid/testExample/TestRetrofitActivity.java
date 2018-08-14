package tzl.com.awesomewanandroid.testExample;

import android.os.Bundle;
import android.view.View;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.activity.BaseActivity;
import tzl.com.awesomewanandroid.data.api.ApiManager;
import tzl.com.awesomewanandroid.data.pojo.ArticleList;
import tzl.com.framework.helper.ToastHelper;
import tzl.com.framework.net.pojo.BaseResponse;
import tzl.com.framework.rx.RxSchedulers;

public class TestRetrofitActivity extends BaseActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_retrofit);
    }


    public void get(View view) {



        ApiManager.getApi().getAricle(1)
                .compose(RxSchedulers.<BaseResponse<ArticleList>>applyObservableAsync())
                .subscribe(new Observer(){

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {
                ToastHelper.showToast(o.toString());
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
