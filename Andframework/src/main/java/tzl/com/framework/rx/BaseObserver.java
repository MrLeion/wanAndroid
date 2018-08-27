package tzl.com.framework.rx;


import java.lang.ref.SoftReference;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import tzl.com.framework.base.BaseActivity;
import tzl.com.framework.helper.LogHelper;
import tzl.com.framework.helper.ToastHelper;
import tzl.com.framework.net.pojo.BaseResponse;

/**
 * author: tangzenglei
 * created on: 2018/8/17 下午4:11
 * description:Observer 统一处理
 */
public abstract class BaseObserver<T> implements Observer<BaseResponse<T>> {


    private SoftReference<BaseActivity> mActivitySoftReference;

    private boolean canLoading = true;


    public BaseObserver() { }

    public BaseObserver(BaseActivity activity, boolean canLoading) {
        mActivitySoftReference = new SoftReference<>(activity);
        this.canLoading = canLoading;
    }

    @Override
    public void onSubscribe(Disposable d) {
        showLoading();
    }



    @Override
    public void onNext(BaseResponse<T> response) {
    if (response.getErrorCode() < 0) {
            onFailure(response);
        } else {
            onSuccess(response);
        }
        hideLoading();
    }

    @Override
    public void onError(Throwable e) {
        hideLoading();
        //TODO:处理错误
        ToastHelper.showToast("请求失败："+e.getStackTrace().toString());
        e.printStackTrace();
    }



    @Override
    public void onComplete() {
        LogHelper.e("onComplete");
        hideLoading();
    }


    private void showLoading() {
        if (isCanLoading()) {
            if (null!= mActivitySoftReference && mActivitySoftReference.get()!=null) {
                mActivitySoftReference.get().showLoading();
            }
        }
    }


    private void hideLoading() {
        if (isCanLoading()) {
            if (null!= mActivitySoftReference && mActivitySoftReference.get()!=null) {
                mActivitySoftReference.get().dismissLoading();
            }
        }
    }

    private boolean isCanLoading() {
        return canLoading;
    }

    public abstract void onSuccess(BaseResponse<T> response);


    public abstract void onFailure(BaseResponse<T> response);


}
