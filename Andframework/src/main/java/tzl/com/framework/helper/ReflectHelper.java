package tzl.com.framework.helper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * author: tangzenglei
 * created on: 2018/9/20 上午11:17
 * description: 反射工具类
 */
public class ReflectHelper {


    public static void setStaticField(Class<?> type, String fieldName, Object value)
            throws NoSuchFieldException, IllegalAccessException {
        setField(type, fieldName, null, value);
    }

    public static void setField(Class<?> type, String fieldName, Object object, Object value)
            throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = type.getDeclaredField(fieldName);
        declaredField.setAccessible(true);
        declaredField.set(object, value);
    }

    public static Object getStaticField(Class<?> type, String filedName)
            throws NoSuchFieldException, IllegalAccessException {
        return getField(type, filedName, null);
    }

    public static Object getField(Class<?> type, String fieldName, Object object)
            throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = type.getDeclaredField(fieldName);
        declaredField.setAccessible(true);
        return declaredField.get(object);
    }

    public static Object invokeStaticMethod(Class<?> type, String method, Class<?>[] paramsTypes, Object[] args)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeMethod(type, method, paramsTypes, null, args);
    }

    public static Object invokeMethod(Class<?> type, String method, Class<?>[] paramsTypes, Object receiver, Object[] args)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method declaredMethod = type.getDeclaredMethod(method, paramsTypes);
        declaredMethod.setAccessible(true);
        return  declaredMethod.invoke(receiver, args);
    }

    public static Object makeProxy(ClassLoader loader, Class<?> base, InvocationHandler handler) {
        List<Class<?>> interfaces = getAllInterfaces(base);
        Class[] ifs = interfaces != null && interfaces.size() > 0 ? interfaces.toArray(new Class[interfaces.size()]) : new Class[0];
        return Proxy.newProxyInstance(loader, ifs, handler);
    }

    public static Object makeProxy(ClassLoader loader, Class<?>[] ifs, InvocationHandler handler) {
        return Proxy.newProxyInstance(loader, ifs, handler);
    }

    public static List<Class<?>> getAllInterfaces(final Class<?> cls) {
        if (cls == null) {
            return null;
        }
        final LinkedHashSet<Class<?>> interfacesFound = new LinkedHashSet<>();
        getAllInterfaces(cls, interfacesFound);
        return new ArrayList<>(interfacesFound);
    }

    private static void getAllInterfaces(Class<?> cls, final HashSet<Class<?>> interfacesFound) {
        while (cls != null) {
            final Class<?>[] interfaces = cls.getInterfaces();

            for (final Class<?> i : interfaces) {
                if (interfacesFound.add(i)) {
                    getAllInterfaces(i, interfacesFound);
                }
            }

            cls = cls.getSuperclass();
        }
    }
}
