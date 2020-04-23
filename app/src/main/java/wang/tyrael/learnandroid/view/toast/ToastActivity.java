package wang.tyrael.learnandroid.view.toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ScheduledExecutorService;

import wang.tyrael.learnandroid.R;

/**
 * 延长Toast时间，只能通过不断的show来解决。需要处理Accessibility事件。
 * 缺点：界面仔细看，每次show的时候会有闪一下，但是不明显（三星t580）。更多机型适配存在风险。
 */
public class ToastActivity extends AppCompatActivity {
    public static String message = "how many seconds 能显示几秒";

    TextView timeView;
    Toast toast;

    private long startTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        timeView = findViewById(R.id.tv_time);
//        timeView.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_NO);

        findViewById(R.id.bn_show_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTime();
                showToast();
            }
        });
        
        startUpdateTime();
    }

    private int count = 10;

    Runnable addToastTimeRunnable = new Runnable() {
        @Override
        public void run() {
            //todo do not commit
            Log.d("tyraelTag", this + "--" + "addToastTimeRunnable run() called");
            //同一个toast show 只生效一次
            toast = Toast.makeText(ToastActivity.this, message, Toast.LENGTH_SHORT);

            //其他方法测试不行。
            View.AccessibilityDelegate delegate = new View.AccessibilityDelegate() {
                @Override
                public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
                    super.onPopulateAccessibilityEvent(host, event);
                    event.setContentDescription("\u00A0");
                }
            };
            ((ViewGroup) toast.getView()).getChildAt(0).setAccessibilityDelegate(delegate);

//            View view = toast.getView();
//            view.setFocusable(true);
//            view.setContentDescription("test test");
//            view.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS);

//            View view = ((ViewGroup) toast.getView()).getChildAt(0);
//            view.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_NO);
//            view.setContentDescription("test test");

            toast.show();
            count--;
            if (count > 0){
                toast.getView().postDelayed(addToastTimeRunnable, 1000);
            }
        }
    };

    private void showToast() {
        toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
        toast.getView().postDelayed(addToastTimeRunnable, 1000);
    }

    public void resetTime(){
        startTime = SystemClock.elapsedRealtime();
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (startTime == 0){
                timeView.setText(String.format("%d秒", 0));
            }else{
                long now = SystemClock.elapsedRealtime();
                timeView.setText(String.format("%d秒", (now-startTime)/1000));
            }
            timeView.postDelayed(runnable, 1000);
        }
    };
    
    public void startUpdateTime(){
        timeView.postDelayed(runnable, 1000);
    }
}
