package tzl.com.framework.net.pojo;

import java.io.Serializable;

/**
 * author: tangzenglei
 * created on: 2018/7/31 下午2:58
 * description:
 */
public class BaseResponse<T> implements Serializable {


    private static final long serialVersionUID = -6695229500545006036L;

    private int errorCode;           // 0 表示返回正常；501 签名错误；502 token验证失败；503 参数错误
    private String errorMsg;    // 信息描述
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
