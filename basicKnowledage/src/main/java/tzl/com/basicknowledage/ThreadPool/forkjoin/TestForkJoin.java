package tzl.com.basicknowledage.ThreadPool.forkjoin;

import android.annotation.SuppressLint;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * author: tangzenglei
 * created on: 2018/11/5 上午11:41
 * description:https://www.ibm.com/developerworks/cn/java/j-lo-forkjoin/index.html
 */
@SuppressLint("NewApi")
public class TestForkJoin {
    
    
    
     public static void main(String[] args){
         ForkJoinPool forkJoinPool = new ForkJoinPool();



        
     /**
      * ================================================================================================
      * ==============================================RecursiveAction=========================================
      * ================================================================================================
      */
//         long[] array = {66, 33, 44, 88};
//         SortTask task = new SortTask(array);
//         forkJoinPool.submit(task);
//         forkJoinPool.shutdown();
//
////         阻塞当前线程直到 ForkJoinPool 中所有的任务都执行结束,否则结果可能不对
//         try {
//             forkJoinPool.awaitTermination(30, TimeUnit.SECONDS);
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         }
//
//         for (int i = 0; i < array.length; i++) {
//             System.out.println(array[i]);
//         }





         /**
          * ================================================================================================
          * ==============================================RecursiveTask=====================================
          * ================================================================================================
          */
         FibonacciTask fibonacciTask = new FibonacciTask(50);
         ForkJoinTask result = forkJoinPool.submit(fibonacciTask);
         try {
             System.out.println(result.get());
         } catch (InterruptedException e) {
             e.printStackTrace();
         } catch (ExecutionException e) {
             e.printStackTrace();
         }




      /**
       * ================================================================================================
       *    ==============================================cyclicAction=========================================
       * ================================================================================================
       */










     }

}
