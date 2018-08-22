package tzl.com.framework.cache;

import android.content.Context;
import android.text.TextUtils;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import tzl.com.framework.helper.LogHelper;

/**
 * @author Maliang
 * @desc
 * @date 2018/3/6 下午12:01.
 */

public class CacheManager {
    public static final String TAG = "wanAndroid";
    private static ACache mACache = null;

    private static Map<String, Object> memCache = new ConcurrentHashMap<>();

    public static void init(Context context) {
        mACache = ACache.get(context);
    }

    /**
     * 存重要信息
     * @param key
     * @param value
     * @param saveTime
     */
    public static void putString(String key, String value, int saveTime) {

        if (TextUtils.isEmpty(key)) {
            LogHelper.e(TAG, "key is null");
            return;
        }
        if (TextUtils.isEmpty(value)){
            LogHelper.e(TAG, "value is null");
            return;
        }

        memCache.put(key, value);

        mACache.put(key, value, saveTime);
    }

    /**
     * 存重要信息
     * @param key
     * @param value
     */
    public static void putString(String key, String value) {
        if (TextUtils.isEmpty(key)) {
            LogHelper.e(TAG, "key is null");
            return;
        }
        if (TextUtils.isEmpty(value)){
            LogHelper.e(TAG, "value is null");
            return;
        }
        memCache.put(key, value);

        mACache.put(key, value);
    }

    /**
     * 取重要信息
     * @param key
     * @return
     */
    public static String getString(String key) {
        if (TextUtils.isEmpty(key)) {
//            LogUtil.e("FZ", "key is null");
            return "";
        }

        if (memCache.containsKey(key)) {
            String value = (String) memCache.get(key);
            if (!TextUtils.isEmpty(value)){
                return value;
            }
        }

        String value = mACache.getAsString(key);
        if (TextUtils.isEmpty(value)){
//            LogUtil.e("FZ", "value is null");
            return "";
        }
        return value;
    }


    /**
     * 存序列化对象
     * @param key
     * @param value
     * @param saveTime
     */
    public static void putObject(String key, Serializable value, int saveTime) {
        if (TextUtils.isEmpty(key)) {
            LogHelper.e(TAG, "key is null");
            return;
        }
        memCache.put(key, value);

        mACache.put(key, value, saveTime);
    }

    public static void putObject(String key, Serializable value) {
        if (TextUtils.isEmpty(key)) {
            LogHelper.e(TAG, "key is null");
            return;
        }
        memCache.put(key, value);

        mACache.put(key, value);
    }

    /**
     * 取序列化对象
     * @param key
     * @return
     */
    public static Object getObject(String key) {
        if (TextUtils.isEmpty(key)) {
            LogHelper.e(TAG, "key is null");
            return null;
        }
        if (memCache.containsKey(key)) {
            Object value = memCache.get(key);
            if (value != null){
                return value;
            }
        }

        return mACache.getAsObject(key);
    }

//    /**
//     * 存bitmap
//     * @param key
//     * @param value
//     */
//    public static void putBitmap(String key, Bitmap value) {
//        if (TextUtils.isEmpty(key)) {
//            LogUtil.e("FZ", "key is null");
//            return;
//        }
//        mACache.put(key, value);
//    }
//
//    /**
//     * 取bitmap
//     * @param key
//     * @return
//     */
//    public static Bitmap getBitmap(String key) {
//        if (TextUtils.isEmpty(key)) {
//            LogUtil.e("FZ", "key is null");
//            return null;
//        }
//        return mACache.getAsBitmap(key);
//    }

    /**
     * 移除缓存
     * @param key
     */
    public static void remove(String key) {
        if (TextUtils.isEmpty(key)) {
            LogHelper.e(TAG, "key is null");
            return;
        }
        memCache.clear();

        mACache.remove(key);
    }

    public static void clear() {
        memCache.clear();

        mACache.clear();
    }

}
