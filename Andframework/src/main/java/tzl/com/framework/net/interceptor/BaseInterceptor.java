package tzl.com.framework.net.interceptor;

import java.io.EOFException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okio.Buffer;

/**
 * @author tangzenglei
 * @desc
 * @date 2017/12/12 下午6:13.
 */
public abstract class BaseInterceptor implements Interceptor {

    protected static final Charset UTF8 = Charset.forName("UTF-8");


    /**
     * Returns true if the body in question probably contains human readable text. Uses a small sample
     * of code points to detect unicode control characters commonly used in binary file signatures.
     */
    protected boolean isPlaintext(Buffer buffer) {
        try {
            Buffer prefix = new Buffer();
            long byteCount = buffer.size() < 64 ? buffer.size() : 64;
            buffer.copyTo(prefix, 0, byteCount);
            for (int i = 0; i < 16; i++) {
                if (prefix.exhausted()) {
                    break;
                }
                int codePoint = prefix.readUtf8CodePoint();
                if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException e) {
            // Truncated UTF-8 sequence.
            return false;
        }
    }
}
