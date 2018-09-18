package tzl.com.java.ThreadPool.Bank;

import java.util.concurrent.locks.ReentrantLock;

/**
 * author: tangzenglei
 * created on: 2018/9/18 上午9:57
 * description: 加入锁
 */
public class LockedCounter implements ICounter{


    private final ReentrantLock mReentrantLock;
    private int balance = 10 * 1000;


    public LockedCounter() {


        mReentrantLock = new ReentrantLock();
    }

    @Override
    public int withDraw(int value) {

        mReentrantLock.lock();
        System.out.println("本次要取出:"+value);
        int temp = balance;
        try {
            Thread.sleep(3 * 1000);
            temp = balance - value;
            Thread.sleep( 1000);
            balance = temp;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("还剩:"+balance);
        mReentrantLock.unlock();
        return balance;
    }

    @Override
    public int deposit(int value) {

        mReentrantLock.lock();
        System.out.println("本次要存入:"+value);

        int temp = balance;
        try {
            Thread.sleep(3 * 1000);
            temp = balance + value;
            Thread.sleep( 1000);
            balance = temp;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("还剩:"+balance);
        mReentrantLock.unlock();
        return balance;
    }
}
