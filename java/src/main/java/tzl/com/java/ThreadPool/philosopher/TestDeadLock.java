package tzl.com.java.ThreadPool.philosopher;

/**
 * author: tangzenglei
 * created on: 2018/9/18 下午2:52
 * description:解决方案：https://www.ibm.com/developerworks/cn/java/j-lo-deadlock/index.html
 */
public class TestDeadLock {
    
     public static void main(String[] args){

         for (int i = 0; i < 100; i++) {
                 HungryPilosophy hungryPilosophy1 = new HungryPilosophy();
                 hungryPilosophy1.start();
         }

     }
}
