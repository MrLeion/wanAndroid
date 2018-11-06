package tzl.com.basicknowledage.ThreadPool.threadcreation;

import java.util.concurrent.Callable;

/**
 * author: tangzenglei
 * created on: 2018/9/18 下午5:49
 * description:
 */
public class ImplementCallable implements Callable<String> {
    @Override
    public String call() throws Exception {


        Thread.sleep(1000);
        return "100 分";
    }
}
