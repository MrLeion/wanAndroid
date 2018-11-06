package tzl.com.basicknowledage.ThreadPool.threadcreation;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * author: tangzenglei
 * created on: 2018/9/18 上午9:41
 * description:
 */
public class TestTheadCreation {
    
    
    
     public static void main(String[] args){

         new InheritThread().start();
         new Thread(new ImplementRunnable()).start();


         // Future Callable
         ExecutorService executorService = Executors.newSingleThreadExecutor();
         Future<String> result = executorService.submit(new ImplementCallable());
         try {
             System.out.println("数学考试结果："+result.get());
         } catch (InterruptedException e) {
             e.printStackTrace();
         } catch (ExecutionException e) {
             e.printStackTrace();
         }


         //FutureTask implement Runnable Future
         FutureTask<String> stringFutureTask = new FutureTask<String>(new ImplementCallable());
         executorService.submit(stringFutureTask);
         try {
             System.out.println("语文考试结果："+stringFutureTask.get());
         } catch (InterruptedException e) {
             e.printStackTrace();
         } catch (ExecutionException e) {
             e.printStackTrace();
         }

         //关闭线程池
         executorService.shutdown();






     }

}
