package tzl.com.framework.helper;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.net.Uri;
import android.os.Looper;
import android.provider.ContactsContract;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * universal util
 */
public class Util {
    /**
     * 隐藏键盘
     *
     * @param view
     */
    public static void hideKeyBoard(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            imm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
        }
    }

    /**
     * 复制到剪切板
     * @param activity
     * @param content
     */
    public static void copyToClipboard(Activity activity, String content) {
        ClipboardManager cm = (ClipboardManager) activity.getSystemService(Context.CLIPBOARD_SERVICE);
        cm.setText(content);
    }

    /**
     * 通过view暴力获取getContext()(Android不支持view.getContext()了)
     *
     * @param view
     *         要获取context的view
     *
     * @return 返回一个activity
     */
    /**
     * 通过 View 获取Activity
     */
    public static Activity getActivity(View view) {
        Context context = view.getContext();
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (Activity) view.getRootView().getContext();
    }

    /**
     * 获取通讯录的内容
     *
     * @param uri
     *
     * @return
     */
    public static String[] getPhoneContacts(Uri uri) {
        String[] contact = new String[2];
        try {
            //得到ContentResolver对象
            ContentResolver cr = ContextHolder.getContext().getContentResolver();
            //取得电话本中开始一项的光标
            Cursor cursor = cr.query(uri, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                //取得联系人姓名
                int nameFieldColumnIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
                contact[0] = cursor.getString(nameFieldColumnIndex);
                //取得电话号码
                String ContactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                /*Cursor phone = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + ContactId, null, null);
                if (phone != null) {
                    phone.moveToFirst();
                    contact[1] = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                }*/

                // 查看联系人有多少个号码，如果没有号码，返回0
                int phoneCount = cursor
                        .getInt(cursor
                                .getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
                Cursor phoneCursor;
                if (phoneCount > 0) {
                    // 获得联系人的电话号码列表
                    phoneCursor = ContextHolder.getContext().getContentResolver().query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID
                                    + "=" + ContactId, null, null);
                    if (phoneCursor.moveToFirst()) {
                        StringBuffer str = new StringBuffer();
                        do {
                            //遍历所有的联系人下面所有的电话号码
                            String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                            str.append(phoneNumber + ",");
                            //使用Toast技术显示获得的号码
                            //Toast.makeText(context, "联系人电话：" + phoneNumber, Toast.LENGTH_LONG).show();
                        }
                        while (phoneCursor.moveToNext());
                        if (str.toString().length() > 0) {
                            contact[1] = str.toString().substring(0, str.toString().length() - 1);
                        }
                    }
                    phoneCursor.close();
                }
                cursor.close();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Error e) {
            e.printStackTrace();
        }
        return contact;
    }

    public static void showKeyboard(Context context) {
        ((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
