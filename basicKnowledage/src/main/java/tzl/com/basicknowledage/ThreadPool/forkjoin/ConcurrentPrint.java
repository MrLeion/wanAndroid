package tzl.com.basicknowledage.ThreadPool.forkjoin;

import android.annotation.SuppressLint;

import java.util.concurrent.RecursiveAction;

/**
 * author: tangzenglei
 * created on: 2018/11/5 下午2:36
 * description:
 */
@SuppressLint("NewApi")
public class ConcurrentPrint extends RecursiveAction {
    @Override
    protected void compute() {
//        TaskBarrier b = new TaskBarrier() {
//            protected boolean terminate(int cycle, int registeredParties) {
//                System.out.println("Cycle is " + cycle + ";"
//                        + registeredParties + " parties");
//                return cycle >= 10;
//            }
//        };
//        int n = 3;
//        CyclicAction[] actions = new CyclicAction[n];
//        for (int i = 0; i < n; ++i) {
//            final int index = i;
//            actions[i] = new CyclicAction(b) {
//                protected void compute() {
//                    System.out.println("I'm working " + getCycle() + " "
//                            + index);
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            };
//        }
//        for (int i = 0; i < n; ++i)
//            actions[i].fork();
//        for (int i = 0; i < n; ++i)
//            actions[i].join();
    }
}
