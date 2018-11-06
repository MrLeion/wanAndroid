package tzl.com.basicknowledage.reflect;

import java.lang.reflect.Method;

/**
 * author: tangzenglei
 * created on: 2018/11/6 下午4:18
 * description: 反射原理:http://rednaxelafx.iteye.com/blog/548536
 *
 */
public class ReflectCase {


    public static void main(String[] args) throws Exception {
        Proxy target = new Proxy();
        Method method = Proxy.class.getDeclaredMethod("run");
        method.invoke(target);
    }

    static class Proxy {
        public void run() {
            System.out.println("run");
        }
    }
}
