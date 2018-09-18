package tzl.com.java.ThreadPool.threadcreation;

/**
 * author: tangzenglei
 * created on: 2018/9/18 上午9:42
 * description:
 */
public class ImplementRunnable implements Runnable {






    /**
     * 定义线程任务
     */
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ImplementRunnable:"+Thread.currentThread().getName());
    }
}
