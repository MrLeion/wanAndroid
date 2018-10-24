package tzl.com.java.designPattern.proxy.staticproxy;

import tzl.com.java.designPattern.proxy.ShoppingImpl;

/**
 * author: tangzenglei
 * created on: 2018/10/23 下午2:31
 * description:
 */
public class TestStaticProxy {
    
    
     public static void main(String[] args){
         StaticProxyShopping staticProxyShopping = new StaticProxyShopping(new ShoppingImpl());
         staticProxyShopping.buySth(10 * 1000);
     }
}
