package wang.tyrael.learnandroid.view.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import wang.tyrael.learnandroid.R;

public class CenterWithoutOverlapActivity extends AppCompatActivity {
    View leftSpace, centerTextView, rightView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);

        leftSpace = findViewById(R.id.space_left);
        centerTextView = findViewById(R.id.tv_center);
        rightView = findViewById(R.id.view_right);

        centerTextView.post(new Runnable() {
            @Override
            public void run() {
                ViewGroup.LayoutParams layoutParams = leftSpace.getLayoutParams();
                layoutParams.width = rightView.getWidth();
                leftSpace.requestLayout();
            }
        });
    }
}
