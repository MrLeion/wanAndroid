package tzl.com.basicknowledage.classLoader.relationship;

/**
 * author: tangzenglei
 * created on: 2018/11/26 4:51 PM
 *sun.misc.Launcher$AppClassLoader
 * sun.misc.Launcher$ExtClassLoader
 *
 * description:类加载器之间的关系
 */
public class RelationShipTest {

     public static void main(String[] args){


         FileClassLoader fileClassLoader = new FileClassLoader();
         System.out.println("自定义类加载器的父加载器: "+fileClassLoader.getParent());
         System.out.println("系统默认的AppClassLoader: "+ClassLoader.getSystemClassLoader());
         System.out.println("AppClassLoader的父类加载器: "+ClassLoader.getSystemClassLoader().getParent());
         System.out.println("ExtClassLoader的父类加载器: "+ClassLoader.getSystemClassLoader().getParent().getParent());

     }
}
