package tzl.com.basicknowledage.ThreadPool.forkjoin;

import android.annotation.SuppressLint;

import java.util.concurrent.RecursiveTask;

/**
 * author: tangzenglei
 * created on: 2018/11/5 下午12:04
 * description: RecursiveTask 伴有返回值
 */
@SuppressLint("NewApi")
public class FibonacciTask extends RecursiveTask<Integer>{
    final int n;

    FibonacciTask(int n) {
        this.n = n;
    }

    private int compute(int small) {
        final int[] results = { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 };
        return results[small];
    }

    public Integer compute() {
        if (n <= 10) {
            return compute(n);
        }
        FibonacciTask f1 = new FibonacciTask(n - 1);
        FibonacciTask f2 = new FibonacciTask(n - 2);


        f1.fork();
        f2.fork();
        return f1.join() + f2.join();
    }


}
