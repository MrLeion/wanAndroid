package tzl.com.framework.detector.ui;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.Choreographer;

/**
 * author: tangzenglei
 * created on: 2019/1/3 4:57 PM
 * description:VSYNC信号 回调
 *
 * 无效
 */
public class ChoreographerBlockDetector implements IBlockDetector {
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void start() {
        Choreographer.getInstance()
                .postFrameCallback(new Choreographer.FrameCallback() {
                    @Override
                    public void doFrame(long l) {
                        if (LogMonitor.getInstance().isMonitor()) {
                            LogMonitor.getInstance().removeMonitor();
                        }
                        LogMonitor.getInstance().startMonitor();
                        Choreographer.getInstance().postFrameCallback(this);
                    }
                });
    }
}
