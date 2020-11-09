package wang.tyrael.learnandroid.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import wang.tyrael.learnandroid.R;

public class TextViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        findViewById(R.id.textView6).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //todo do not commit
                Log.d("tyraelTag", this + "--" + "onTouch() called with: v = [" + v + "], event = [" + event + "]");
                return false;
            }
        });
    }
}
