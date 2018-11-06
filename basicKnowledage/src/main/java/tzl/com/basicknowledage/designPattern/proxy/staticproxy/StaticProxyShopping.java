package tzl.com.basicknowledage.designPattern.proxy.staticproxy;

import tzl.com.java.designPattern.proxy.IShopping;

/**
 * author: tangzenglei
 * created on: 2018/10/23 下午12:51
 * description:
 */
public class StaticProxyShopping implements IShopping {


    private IShopping mBase;


    public StaticProxyShopping(IShopping base) {
        mBase = base;
    }

    @Override
    public Object[] buySth(int money) {
        mBase.buySth(money);
        System.out.println(String.format("静态帮助购物,只要花%s元钱",money*0.8));
        return new Object[]{"A货包包","A货鞋子","A货衣服"};
    }
}
