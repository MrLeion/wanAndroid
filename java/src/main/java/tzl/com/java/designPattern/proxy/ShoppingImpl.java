package tzl.com.java.designPattern.proxy;

/**
 * author: tangzenglei
 * created on: 2018/10/23 下午12:50
 * description:
 */
public class ShoppingImpl implements IShopping {


    @Override
    public Object[] buySth(int money) {
        System.out.println(String.format("开始购物,准备花%s元钱",money));
        return new Object[]{"包包","鞋子","衣服"};
    }
}
