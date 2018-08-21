package tzl.com.framework.rx;


import java.lang.ref.SoftReference;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import tzl.com.framework.base.BaseActivity;
import tzl.com.framework.net.pojo.BaseResponse;

/**
 * author: tangzenglei
 * created on: 2018/8/17 下午4:11
 * description:
 */
public abstract class BaseObserver<T> implements Observer<BaseResponse<T>> {


    private SoftReference<BaseActivity> mBaseActivitySoftReference;

    private boolean canLoading = true;


    public BaseObserver() {

    }

    public BaseObserver(SoftReference<BaseActivity> baseActivitySoftReference, boolean canLoading) {
        mBaseActivitySoftReference = baseActivitySoftReference;
        this.canLoading = canLoading;
    }

    @Override
    public void onSubscribe(Disposable d) {

        if (isCanLoading()) {
            mBaseActivitySoftReference.get().showLoading();
        }

    }

    @Override
    public void onNext(BaseResponse<T> response) {

        if (response.getErrorCode() < 0) {
            onFailure(response);
        } else {
            onSuccess(response);
        }


    }

    @Override
    public void onError(Throwable e) {
        //TODO:处理错误



    }

    @Override
    public void onComplete() {

        if (isCanLoading()) {
            mBaseActivitySoftReference.get().dismissLoading();
        }
    }


    private boolean isCanLoading() {
        return isCanLoading();
    }

    public abstract void onSuccess(BaseResponse<T> response);


    public abstract void onFailure(BaseResponse<T> response);


}
