package tzl.com.basicknowledage.classLoader.customLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * author: tangzenglei
 * created on: 2018/11/26 5:34 PM
 * description:
 */
public class FileClassLoader1 extends ClassLoader {


    private String rootDir;


    public FileClassLoader1(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {


        //读取字节流传递给 defineClass 从而生成对应的对象
        byte[] byteArray = readFromByteStream(name);

        if (null == byteArray) {
            throw new ClassNotFoundException();
        }

        return defineClass(name, byteArray, 0, byteArray.length);
    }

    private byte[] readFromByteStream(String className) {
        // 读取类文件的字节
        String path = classNameToPath(className);
        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            // 读取类文件的字节码
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 类文件的完全路径
     * @param className
     * @return
     */
    private String classNameToPath(String className) {
        return rootDir + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
    }



    public static void main(String[] args) throws ClassNotFoundException {
        String rootDir="/Users/tangzenglei/AndroidStudioProjects/wanAndroid/basicKnowledage/src/main/java/tzl/com/basicknowledage/classLoader/";
        //创建自定义文件类加载器
        FileClassLoader1 loader = new FileClassLoader1(rootDir);

        try {
            //加载指定的class文件
            Class<?> object1=loader.loadClass("tzl.com.basicknowledage.classLoader.customLoader.Obj");
            System.out.println("called from FileClassLoader1");
            System.out.println(object1.newInstance().toString());
            //输出结果:I am DemoObj
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
