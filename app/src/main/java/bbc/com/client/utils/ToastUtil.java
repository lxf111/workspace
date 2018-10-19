package bbc.com.client.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Evan_Jhon on 2018/5/30.
 * evan_jhon@163.com
 * description
 */

public class ToastUtil {
    private static Toast toast;

    /**
     * 短时间显示Toast
     *
     * @param context
     * @param message
     */
    public static Toast showShort(Context context, CharSequence message) {
        if (null == toast) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        } else {
            toast.setText(message);
        }
        toast.show();

        return toast;
    }
}
