package tzl.com.java.ThreadPool.threadcreation;

/**
 * author: tangzenglei
 * created on: 2018/9/18 上午9:40
 * description:
 */
public class InheritThread extends Thread {


    /**
     * 定义线程任务
     */
    @Override
    public void run() {


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("InheritThread:"+Thread.currentThread().getName());

    }
}
