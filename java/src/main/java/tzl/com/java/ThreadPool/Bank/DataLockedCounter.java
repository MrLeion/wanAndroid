package tzl.com.java.ThreadPool.Bank;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * author: tangzenglei
 * created on: 2018/9/18 上午9:57
 * description: 资源封锁
 */
public class DataLockedCounter implements ICounter{


    private AtomicInteger balance = new AtomicInteger(10 * 1000);

    @Override
    public int withDraw(int value) {

        System.out.println("本次要取出:"+value);
        balance.set(balance.intValue()-value);
        System.out.println("还剩:"+balance);
        return 0;
    }

    @Override
    public int deposit(int value) {

        System.out.println("本次要取出:"+value);

        balance.set(balance.intValue()+value);
        System.out.println("还剩:"+balance);
        return 0;
    }
}
