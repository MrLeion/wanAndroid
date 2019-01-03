package tzl.com.framework.detector.ui;

import android.os.Looper;
import android.util.Printer;

/**
 * author: tangzenglei
 * created on: 2019/1/3 3:44 PM
 * description:
 */
public class PrinterBlockDetector implements IBlockDetector {


    private static final String START = ">>>>> Dispatching";
    private static final String END   = "<<<<< Finished";

    public void start() {
        Looper.getMainLooper().setMessageLogging(new Printer() {
            @Override
            public void println(String x) {
                if (x.startsWith(START)) {
                    LogMonitor.getInstance().startMonitor();
                }
                if (x.startsWith(END)) {
                    LogMonitor.getInstance().removeMonitor();
                }
            }
        });
    }
}
