package bbc.com.client.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/3/10 0010.
 */

public class TimerTextView extends TextView implements Runnable {

    public TimerTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    private long mday, mhour, mmin, msecond;//天，小时，分钟，秒
    private boolean run = false; //是否启动了

    public void setTimes(long[] times) {
        mday = times[0];
        mhour = times[1];
        mmin = times[2];
        msecond = times[3];
    }

    /**
     * 倒计时计算
     */
    private void ComputeTime() {
        msecond--;
        if (msecond < 0) {
            mmin--;
            msecond = 59;
            if (mmin < 0) {
                mmin = 59;
                mhour--;
                if (mhour < 0) {
                    // 倒计时结束，一天有24个小时
                    mhour = 23;
                    mday--;

                }
            }

        }

    }

    public boolean isRun() {
        return run;
    }

    public void beginRun() {
        this.run = true;
        run();
    }

    public void stopRun() {
        this.run = false;
    }


    @Override
    public void run() {
        //标示已经启动
        if (run) {
            ComputeTime();

            String strTime = "";
            if (mday <= 0) {
                if (mhour <= 0) {
                    if (mmin == 0) {
                        strTime = msecond + "秒";
                    } else {
                        strTime = mmin + "分" + msecond + "秒";
                    }
                } else {
                    strTime = mhour + "时" + mmin + "分" + msecond + "秒";
                }
            } else {
                strTime = mday + "天" + mhour + "时" + mmin + "分" + msecond + "秒";
            }

            this.setText(strTime);
            postDelayed(this, 1000);
        } else {
            removeCallbacks(this);
        }
    }

}