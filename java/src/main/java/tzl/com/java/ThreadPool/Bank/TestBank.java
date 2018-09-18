package tzl.com.java.ThreadPool.Bank;

/**
 * author: tangzenglei
 * created on: 2018/9/18 上午9:57
 * description:模拟银行多个窗口(线程) 取钱，这里需要维持金额的可见性
 */
public class TestBank {



     public static void main(String[] args){


//         ICounter counter = new ProblemCounter();
//         ICounter counter = new LockedCounter();
//         ICounter counter = new SynchronizedHelper1(new Object(),new LockedCounter());
         ICounter counter = new SynchronizedHelper3(new LockedCounter());

         WindowThread windowThread1 = new WindowThread(counter);
         WindowThread windowThread2= new WindowThread(counter);
         WindowThread windowThread3 = new WindowThread(counter);
         WindowThread windowThread4 = new WindowThread(counter);
         windowThread1.start();
         windowThread2.start();
         windowThread3.start();
         windowThread4.start();
     }


}
