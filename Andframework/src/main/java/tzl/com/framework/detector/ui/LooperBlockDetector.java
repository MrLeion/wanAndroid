package tzl.com.framework.detector.ui;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * author: tangzenglei
 * created on: 2019/1/3 5:00 PM
 * description: 是否可以通过
 * 动态代理的方式处理
 *
 * https://github.com/JakeWharton/hugo
 *
 *
 *
 *无效
 */
public class LooperBlockDetector implements IBlockDetector {


    private static final String FIELD_MQUEUE = "mQueue";
    private static final String METHOD_NEXT  = "next";

    @Override
    public void start() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                try {
                    Looper mainLooper = Looper.getMainLooper();
                    final Looper me = mainLooper;
                    final MessageQueue queue;
                    Field fieldQueue = me.getClass().getDeclaredField(FIELD_MQUEUE);
                    fieldQueue.setAccessible(true);
                    queue = (MessageQueue) fieldQueue.get(me);
                    Method methodNext = queue.getClass().getDeclaredMethod(METHOD_NEXT);
                    methodNext.setAccessible(true);
                    Binder.clearCallingIdentity();
                    for (; ; ) {
                        Message msg = (Message) methodNext.invoke(queue);
                        if (msg == null) {
                            return;
                        }
                        LogMonitor.getInstance().startMonitor();
                        msg.getTarget().dispatchMessage(msg);
                        msg.recycle();
                        LogMonitor.getInstance().removeMonitor();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
