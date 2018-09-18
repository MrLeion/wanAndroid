package tzl.com.java.ThreadPool.threadcreation;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * author: tangzenglei
 * created on: 2018/9/18 上午9:41
 * description:
 */
public class TestTheadCreation {
    
    
    
     public static void main(String[] args){

         new InheritThread().start();
         new Thread(new ImplementRunnable()).start();


         ExecutorService executorService = Executors.newSingleThreadExecutor();
         Future<String> result = executorService.submit(new ImplementCallable());
         try {
             System.out.println("数学考试结果："+result.get());
         } catch (InterruptedException e) {
             e.printStackTrace();
         } catch (ExecutionException e) {
             e.printStackTrace();
         }
     }

}
