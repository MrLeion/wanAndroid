package tzl.com.framework.rx;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import tzl.com.framework.net.pojo.BaseResponse;

/**
 * author: tangzenglei
 * created on: 2018/8/17 下午4:11
 * description:
 */
public abstract class BaseObserver<T> implements Observer<BaseResponse<T>> {







    @Override
    public void onSubscribe(Disposable d) {

        

    }

    @Override
    public void onNext(BaseResponse<T> response) {


        if (response.getErrorCode()<0) {
            onFailure(response);
        }else{
            onSuccess(response);
        }







    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {


    }


    public abstract void onSuccess (BaseResponse<T> response);


    public abstract void onFailure(BaseResponse<T> response);







}
