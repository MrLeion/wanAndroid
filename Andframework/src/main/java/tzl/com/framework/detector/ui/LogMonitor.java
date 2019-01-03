package tzl.com.framework.detector.ui;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;

import java.lang.reflect.Method;

import tzl.com.framework.helper.LogHelper;

/**
 * author: tangzenglei
 * created on: 2019/1/3 4:42 PM
 * description:
 */
public class LogMonitor {


    private static LogMonitor    sInstance  = new LogMonitor();
    private        HandlerThread mLogThread = new HandlerThread("log");
    private Handler mIoHandler;
    private static final long TIME_BLOCK = 1000L;

    private LogMonitor() {
        mLogThread.start();
        mIoHandler = new Handler(mLogThread.getLooper());
    }

    private static Runnable mLogRunnable = new Runnable() {
        @Override
        public void run() {

            StringBuilder sb = new StringBuilder();
            StackTraceElement[] stackTraces = Looper.getMainLooper().getThread().getStackTrace();
            for (StackTraceElement s : stackTraces) {
                sb.append(s.toString() + "\n");
            }
            LogHelper.e(sb.toString());


            //                        StringBuilder sb = new StringBuilder();
            //                        StackTraceElement[] stackTraces = Looper.getMainLooper().getThread().getStackTrace();
            //                        for (StackTraceElement s : stackTraces) {
            //                            sb.append(s.toString() + "\n");
            //                        }
            //                        LogText.e("TAG", sb.toString());


        }
    };


    public static LogMonitor getInstance() {
        return sInstance;
    }

    public boolean isMonitor() {
        boolean isMonitor = false;

        //反射调用 mIoHandler.hasCallbacks(mLogRunnable)
        Method[] methods =
                mIoHandler.getClass().getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            if ("hasCallbacks".equals(methods[i])) {
                try {
                    isMonitor = (boolean) methods[i].invoke(mIoHandler, mLogRunnable);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return isMonitor;
    }

    public void startMonitor() {
        mIoHandler.postDelayed(mLogRunnable, TIME_BLOCK);
    }

    public void removeMonitor() {
        mIoHandler.removeCallbacks(mLogRunnable);
    }


    private static class LogText {
        private static final String DOUBLE_DIVIDER = "════════════════════════════════════════════\n";
        private static final String SINGLE_DIVIDER = "────────────────────────────────────────────\n";

        private String mTag;

        public LogText(String tag) {
            mTag = tag;
        }


        public static void e(String tag, String content) {
            LogText logText = new LogText(tag);
            logText.setup(content);
        }

        public void setup(String content) {
            setUpHeader();
            setUpContent(content);
            setUpFooter();

        }

        private void setUpHeader() {
            Log.e(mTag, SINGLE_DIVIDER);
        }

        private void setUpFooter() {
            Log.e(mTag, DOUBLE_DIVIDER);
        }

        public void setUpContent(String content) {
            StackTraceElement targetStackTraceElement = getTargetStackTraceElement();
            Log.e(mTag, "(" + targetStackTraceElement.getFileName() + ":"
                    + targetStackTraceElement.getLineNumber() + ")");
            Log.e(mTag, content);
        }

        private StackTraceElement getTargetStackTraceElement() {
            // find the target invoked method
            StackTraceElement targetStackTrace = null;
            boolean shouldTrace = false;
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                Log.e("TAG", stackTraceElement.toString());
                boolean isLogMethod = stackTraceElement.getClassName().equals(LogMonitor.class.getName());
                if (shouldTrace && !isLogMethod) {
                    targetStackTrace = stackTraceElement;
                    break;
                }
                shouldTrace = isLogMethod;
            }
            return targetStackTrace;
        }
    }


}
