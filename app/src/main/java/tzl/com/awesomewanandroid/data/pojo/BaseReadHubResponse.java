package tzl.com.awesomewanandroid.data.pojo;

import java.io.Serializable;

/**
 * author: tangzenglei
 * created on: 2018/7/31 下午2:58
 * description:根据后台返回数据结构构建
 */
public class BaseReadHubResponse<T> implements Serializable {


    private static final long serialVersionUID = -6695229500545006036L;

    private int pageSize;
    private int            totalItems;
    private int            totalPages;
    private T data;           // 返回的结果数据，具体字段解析见返回字段说明

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
