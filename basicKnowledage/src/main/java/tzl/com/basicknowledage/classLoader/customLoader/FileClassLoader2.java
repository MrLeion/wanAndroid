package tzl.com.basicknowledage.classLoader.customLoader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

/**
 * author: tangzenglei
 * created on: 2018/11/26 5:34 PM
 * description:
 */
public class FileClassLoader2 extends URLClassLoader {


    public FileClassLoader2(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public FileClassLoader2(URL[] urls) {
        super(urls);
    }

    public FileClassLoader2(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }

    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {
        String rootDir = "/Users/tangzenglei/AndroidStudioProjects/wanAndroid/basicKnowledage/src/main/java/tzl/com/basicknowledage/classLoader/";


        File file = new File(rootDir);

        URI uri = file.toURI();

        URL[] urls = {uri.toURL()};
        //创建自定义文件类加载器

        FileClassLoader2 loader = new FileClassLoader2(urls);

        try {
            //加载指定的class文件
            Class<?> object1 = loader.loadClass("tzl.com.basicknowledage.classLoader.customLoader.Obj");
            System.out.println("called from FileClassLoader2");
            System.out.println(object1.newInstance().toString());
            //输出结果:I am DemoObj
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
