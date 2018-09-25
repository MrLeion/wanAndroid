package tzl.com.java.designPattern.singleton;

import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * author: tangzenglei
 * created on: 2018/9/21 下午2:59
 * description: 延迟加载的饿汉模式
 */
public class Singleton implements Serializable {

    private Singleton() {

        //避免反射
        if (SingletonHolder.INSTANCE!=null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }


    public static class SingletonHolder{
        public static final Singleton INSTANCE  = new Singleton();
    }



    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }



    //Make singleton from serialize and deserialize operation.
    protected Singleton readResolve() {
        return getInstance();
    }






     public static void main(String[] args){

        //序列化
//         try {
//             Singleton instance1 = Singleton.getInstance();
//             ObjectOutput out = null;
//
//             out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
//             out.writeObject(instance1);
//             out.close();
//
//             //deserialize from file to object
//             ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
//             Singleton instance2 = (Singleton) in.readObject();
//             in.close();
//
//             System.out.println("instance1 hashCode=" + instance1.hashCode());
//             System.out.println("instance2 hashCode=" + instance2.hashCode());
//
//         } catch (Exception e) {
//             e.printStackTrace();
//         }

         //反射

         //Create the 1st instance
         Singleton instance1 = Singleton.getInstance();

         //Create 2nd instance using Java Reflection API.
         Singleton instance2 = null;
         try {
             Class<Singleton> clazz = Singleton.class;
             Constructor<Singleton> cons = clazz.getDeclaredConstructor();
             cons.setAccessible(true);
             instance2 = cons.newInstance();
         } catch (Exception e) {
             e.printStackTrace();
         }

         //now lets check the hash key.
         System.out.println("Instance 1 hash:" + instance1.hashCode());
         System.out.println("Instance 2 hash:" + instance2.hashCode());


      }







}
