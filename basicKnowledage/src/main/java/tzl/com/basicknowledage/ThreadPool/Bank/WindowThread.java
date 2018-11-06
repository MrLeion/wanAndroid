package tzl.com.basicknowledage.ThreadPool.Bank;

/**
 * author: tangzenglei
 * created on: 2018/9/18 上午9:54
 * description:
 */
public class WindowThread extends Thread {


    private ICounter mICounter;


    public WindowThread( ICounter iCounter) {
        mICounter = iCounter;
    }


    @Override
    public void run() {
        mICounter.withDraw(500);
        mICounter.deposit(500);
        mICounter.withDraw(500);
        mICounter.deposit(500);
        mICounter.withDraw(1000);
    }
}
