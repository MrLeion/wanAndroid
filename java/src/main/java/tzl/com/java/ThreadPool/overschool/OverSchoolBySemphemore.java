package tzl.com.java.ThreadPool.overschool;

import java.util.concurrent.Semaphore;

/**
 * author: tangzenglei
 * created on: 2018/9/21 下午5:28
 * description:  阻塞主线程，子线程正常执行
 */
public class OverSchoolBySemphemore {

    static Semaphore sSemaphore = new Semaphore(10);


     public static void main(String[] args) throws InterruptedException {

         for (int i = 0; i < 10; i++) {
             new Thread(){
                 @Override
                 public void run() {
//                     try {
//                         Thread.sleep(1000);
//
//                     } catch (InterruptedException e) {
//                         e.printStackTrace();
//                     }
                     try {
                         sSemaphore.acquire();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     System.out.println(Thread.currentThread().getName()+"到了门边上~~");
                 }
             }.start();
         }


         sSemaphore.release();
         System.out.println("开门放学了~~");




      }



    
    
    

}
