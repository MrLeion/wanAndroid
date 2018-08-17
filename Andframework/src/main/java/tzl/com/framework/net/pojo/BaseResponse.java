package tzl.com.framework.net.pojo;

import java.io.Serializable;

/**
 * author: tangzenglei
 * created on: 2018/7/31 下午2:58
 * description:根据后台返回数据结构构建
 */
public class BaseResponse<T> implements Serializable {


    private static final long serialVersionUID = -6695229500545006036L;

    private int errorCode; //<0 非正常
    private String errorMsg;    // 错误信息
    private T data;           // 返回的结果数据，具体字段解析见返回字段说明

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
