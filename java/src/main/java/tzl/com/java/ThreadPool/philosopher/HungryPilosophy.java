package tzl.com.java.ThreadPool.philosopher;

/**
 * author: tangzenglei
 * created on: 2018/9/18 下午2:44
 * description: 解决方案：https://www.ibm.com/developerworks/cn/java/j-lo-deadlock/index.html
 */
public class HungryPilosophy extends Thread {


   static final ChopStick left = new ChopStick();
   static final ChopStick right = new ChopStick();


    /**
     * 先拿左边筷子，然后拿住不放去拿右边的筷子
     */
    private void eat1() {
        synchronized (left) {
            getLeft();
            System.out.println(Thread.currentThread().getName()+"拿起左边的筷子，正准备拿右边的筷子");
            synchronized (right) {
                getRight();
                System.out.println(Thread.currentThread().getName()+"拿起右边的筷子，正准备吃饭了");
            }
        }
    }

    /**
     * 先拿右边筷子，然后拿住不放去拿左边的筷子
     */
    private void eat2() {
        synchronized (right) {
            getLeft();
            System.out.println(Thread.currentThread().getName()+"拿起左边的筷子，正准备拿右边的筷子");
            synchronized (left) {
                getRight();
                System.out.println(Thread.currentThread().getName()+"拿起右边的筷子，正准备吃饭了");
            }
        }
    }



    public ChopStick getLeft() {
        return left;
    }

    public ChopStick getRight() {
        return right;
    }

    @Override
    public void run() {

        while (true) {
            eat1();
//            eat1();
            eat2();
        }


    }
}
