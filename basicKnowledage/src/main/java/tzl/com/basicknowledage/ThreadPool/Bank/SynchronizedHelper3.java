package tzl.com.basicknowledage.ThreadPool.Bank;

/**
 * author: tangzenglei
 * created on: 2018/9/18 上午9:57
 * description:synchronized 关键字，思路参见 Collections.synchronizedMap()
 *
 * synchronized 保证了操作的原子性
 *
 * 同步代码块的锁是任意对象。只要不同的线程都执行同一个同步代码块的时候，这个锁随便设。
 同步函数的锁是固定的this。当需要和同步函数中的逻辑实行同步的时候，代码块中的锁必须为this。
 静态同步函数的锁是该函数所属类的字节码文件对象。该对象可以用this.getClass()方法获取，也可以使用 当前类名.class 表示。
 *
 */
public class SynchronizedHelper3 implements ICounter{



    ICounter mICounter;

    public SynchronizedHelper3( ICounter counter) {
        mICounter = counter;
    }


    /**
     * 非静态同步函数锁对象 this
     * @param value
     * @return
     */
    @Override
    public synchronized int withDraw(int value) {
        // this?
            return mICounter.withDraw(value);
    }

    @Override
    public synchronized int deposit(int value) {
            return mICounter.deposit(value);
    }
}
