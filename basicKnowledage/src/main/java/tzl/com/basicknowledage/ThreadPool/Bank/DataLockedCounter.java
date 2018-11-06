package tzl.com.basicknowledage.ThreadPool.Bank;

/**
 * author: tangzenglei
 * created on: 2018/9/18 上午9:57
 * description: 资源封锁
 * https://blog.csdn.net/qq_30379689/article/details/80785650
 */
public class DataLockedCounter implements ICounter{


    //对于值的操作，会立即更新到主存中，当其他线程获取最新值时会从主存中获取

    private volatile int balance = 10 * 1000;

    //对于值的操作，是基于底层硬件处理器提供的原子指令，保证并发时线程的安全
//    private AtomicInteger balance = new AtomicInteger(10 * 1000);

//    @Override
//    public int withDraw(int value) {
//
//        System.out.println("本次要取出:"+value);
//        balance.set(balance.intValue()-value);
//        System.out.println("还剩:"+balance);
//        return 0;
//    }
//
//    @Override
//    public int deposit(int value) {
//
//        System.out.println("本次要取出:"+value);
//
//        balance.set(balance.intValue()+value);
//        System.out.println("还剩:"+balance);
//        return 0;
//    }


    /**
     * JVM 指令
     26: aload_0 //初始化加载局部变量
     27: getfield      #2                  // Field balance:I
     30: iload_1 //加载局部变量
     31: iadd    //加减运算
     32: putfield      #2                  // Field balance:I
     * @param value
     * @return
     */

    @Override
    public int withDraw(int value) {

        System.out.println("本次要取出:"+value);
        balance = balance - value;
        System.out.println("还剩:"+balance);
        return 0;
    }

    @Override
    public int deposit(int value) {

        System.out.println("本次要取出:"+value);
        balance = balance + value;
        System.out.println("还剩:"+balance);
        return 0;
    }
}
