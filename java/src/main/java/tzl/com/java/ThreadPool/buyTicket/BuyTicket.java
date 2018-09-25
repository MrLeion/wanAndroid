package tzl.com.java.ThreadPool.buyTicket;

/**
 * author: tangzenglei
 * created on: 2018/9/19 下午9:22
 * description:
 */
public class BuyTicket extends Thread {

    int data = 100;


    @Override
    public void run() {
        while (data>0) {
            synchronized (this) {
                if (data>0) {
                    System.out.println(Thread.currentThread().getName()+"已买到第"+data+"张票，还剩"+--data+"张");
                }
            }
        }
    }
}
