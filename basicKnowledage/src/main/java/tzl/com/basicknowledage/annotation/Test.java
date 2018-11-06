package tzl.com.basicknowledage.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author: tangzenglei
 * created on: 2018/9/6 下午5:25
 * description:
 * 注解学习：
 * https://blog.csdn.net/briblue/article/details/73824058
 *
 * RetentionPolicy.CLASS 编译生成代码
 * RetentionPolicy.RUNTIME 生成代码，保存到运行时
 * RetentionPolicy.SOURCE
 *
 *
 * 注：编译时注解并不是通过反射API来获得注解类的
 *
 *
 * @Target 定义锁作用的范围
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface Test {

}
