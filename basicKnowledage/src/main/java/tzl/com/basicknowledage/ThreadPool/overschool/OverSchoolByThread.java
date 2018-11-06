package tzl.com.basicknowledage.ThreadPool.overschool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * author: tangzenglei
 * created on: 2018/9/21 下午5:28
 * description: 阻塞主线程，子线程正常执行
 */
public class OverSchoolByThread  {
    


     static AtomicInteger count = new AtomicInteger(10);



     public static void main(String[] args){


         for (int i = 0; i < 10; i++) {
             new Thread(){
                 @Override
                 public void run() {
                     try {
                         Thread.sleep(1000);

                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     System.out.println("第"+ count.decrementAndGet()+"到了门边上~~");
                 }
             }.start();
         }

        while (count.intValue()>0);
         System.out.println("开门放学了~~");
      }



    
    
    

}
