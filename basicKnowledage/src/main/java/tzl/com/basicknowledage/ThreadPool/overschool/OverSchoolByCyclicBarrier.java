package tzl.com.basicknowledage.ThreadPool.overschool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * author: tangzenglei
 * created on: 2018/9/21 下午5:28
 * description:主线程正常运行，子线程阻塞
 */
public class OverSchoolByCyclicBarrier {


    static CyclicBarrier sCyclicBarrier = new CyclicBarrier(10, new Runnable() {
        @Override
        public void run() {
            System.out.println("开门放学了~~");
        }
    });








     public static void main(String[] args) throws InterruptedException {
         for (int i = 0; i < 10; i++) {
             new Thread(){
                 @Override
                 public void run() {
                     try {
                         Thread.sleep(1000);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }

                     System.out.println(Thread.currentThread().getName()+"到了门边上~~");
                     try {
                         sCyclicBarrier.await();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     } catch (BrokenBarrierException e) {
                         e.printStackTrace();
                     }
                     
                     System.out.println(Thread.currentThread().getName()+"放学回家~~");
                    
                 }
             }.start();
         }
         System.out.println("teacher is leaving~~");
      }



    
    
    

}
