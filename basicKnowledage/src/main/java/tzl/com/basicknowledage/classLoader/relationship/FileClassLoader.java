package tzl.com.basicknowledage.classLoader.relationship;

/**
 * author: tangzenglei
 * created on: 2018/11/26 4:52 PM
 * description:
 */
public class FileClassLoader extends ClassLoader {


    /**
     * 加载 .class ，invoke super.loadClass()
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {


        return null;
    }



    //编写读取字节流的方法
    private byte[] readClasses(String className) {
        // 读取类文件的字节
        //省略代码....


        return null;
    }

























}
