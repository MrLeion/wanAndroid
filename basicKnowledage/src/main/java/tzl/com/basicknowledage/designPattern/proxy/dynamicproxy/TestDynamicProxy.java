package tzl.com.basicknowledage.designPattern.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

import tzl.com.basicknowledage.designPattern.proxy.IShopping;
import tzl.com.basicknowledage.designPattern.proxy.ShoppingImpl;


/**
 * author: tangzenglei
 * created on: 2018/10/23 下午2:31
 * description:
 */
public class TestDynamicProxy {
    
     public static void main(String[] args){


         IShopping dynamicProxyShopping = (IShopping) Proxy.newProxyInstance(ShoppingImpl.class.getClassLoader(), ShoppingImpl.class.getInterfaces(), new ShoppingHandler(new ShoppingImpl()));
         dynamicProxyShopping.buySth(1000 * 10);
     }
}
