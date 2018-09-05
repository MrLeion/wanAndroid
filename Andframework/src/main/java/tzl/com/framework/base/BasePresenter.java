package tzl.com.framework.base;

/**
 * author: tangzenglei
 * created on: 2018/9/5 上午10:08
 * description: mvp - presenter
 * view model 双重绑定
 */
public abstract class BasePresenter<V extends IView,M extends BaseModel> {

    protected V mView;
    protected M mModel;
    protected BaseActivity mActivity;


    /**
     * 绑定 View 和 model
     * @param view
     */
    public BasePresenter(V view,M model) {
        mView = view;
        mModel = model;
        if (view instanceof BaseActivity) {
            mActivity = (BaseActivity) view;
        } else if (view instanceof BaseFragment) {
            mActivity = (BaseActivity) ((BaseFragment) view).getActivity();
        }
        init();
        registerEvent();
    }


    /**
     * 解除 View 和 model
     */
    public void onDestory(){
        mView= null;
        mModel = null;
    }


    public abstract void init();
    public abstract void registerEvent();


}
