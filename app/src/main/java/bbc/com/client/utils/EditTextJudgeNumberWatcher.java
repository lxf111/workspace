package bbc.com.client.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by Administrator on 2018/5/15 0015.
 */

public class EditTextJudgeNumberWatcher implements TextWatcher {
    private EditText editText;

    public EditTextJudgeNumberWatcher(EditText editText) {
        this.editText = editText;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        judgeNumber(editable, editText);
    }

    /**
     * 金额输入框中的内容限制（最大：小数点前五位，小数点后2位）
     *
     * @param edt
     */
    public static void judgeNumber(Editable edt, EditText editText) {

        String temp = edt.toString();
        int posDot = temp.indexOf(".");//返回指定字符在此字符串中第一次出现处的索引
        int index = editText.getSelectionStart();//获取光标位置
        //  if (posDot == 0) {//必须先输入数字后才能输入小数点
        //  edt.delete(0, temp.length());//删除所有字符
        //  return;
        //  }
        if (posDot < 0) {//不包含小数点

            if (temp.length() > 0 && temp.substring(0, 1).equals("0")) {
                if (temp.length() > 1 && !temp.equals("0.")) {
                    edt.delete(index - 1, index);//删除光标前的字符
                    return;
                }
            }

            if (temp.length() <= 9) {
                return;//小于五位数直接返回
            } else {
                edt.delete(index - 1, index);//删除光标前的字符
                return;
            }
        }
        if (posDot > 9) {//小数点前大于5位数就删除光标前一位
            edt.delete(index - 1, index);//删除光标前的字符
            return;
        }
        if (temp.length() - posDot - 1 > 2)//如果包含小数点
        {
            edt.delete(index - 1, index);//删除光标前的字符
            return;
        }
    }
}
