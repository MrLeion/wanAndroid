package tzl.com.java.designPattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * author: tangzenglei
 * created on: 2018/10/23 下午2:36
 * description:
 */
public class ShoppingHandler implements InvocationHandler {


    private Object base;


    public ShoppingHandler(Object base) {
        this.base = base;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        Class<?>[] types = method.getParameterTypes();

        if ("buySth".equals(method.getName())
                && types.length ==1
                && types[0] == int.class) {
            Integer money = (Integer) args[0];
            method.invoke(base, money);
            System.out.println(String.format("动态帮助购物,只要花%s元钱",money*0.8));
        }


        return null;
    }
}
