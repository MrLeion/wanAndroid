package tzl.com.basicknowledage.ThreadPool.Bank;

/**
 * author: tangzenglei
 * created on: 2018/9/18 上午9:57
 * description:
 */
public class ProblemCounter implements ICounter{


    private int balance = 10 * 1000;



    @Override
    public int withDraw(int value) {

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
        return balance;
    }

    @Override
    public int deposit(int value) {

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
        return balance;
    }
}
