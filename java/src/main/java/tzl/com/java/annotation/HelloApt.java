package tzl.com.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author: tangzenglei
 * created on: 2018/9/6 下午5:25
 * description:https://blog.csdn.net/briblue/article/details/73824058
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface HelloApt {

}
