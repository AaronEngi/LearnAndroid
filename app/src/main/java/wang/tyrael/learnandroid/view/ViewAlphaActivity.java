package wang.tyrael.learnandroid.view;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;

import wang.tyrael.learnandroid.databinding.ActivityViewAlphaBinding;

public class ViewAlphaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityViewAlphaBinding viewBinding = ActivityViewAlphaBinding.inflate(LayoutInflater.from(this));
        setContentView(viewBinding.getRoot());

        viewBinding.switch1.setOnCheckedChangeListener((compoundButton, b) -> {
            viewBinding.parentLayout.setAlpha(b ? 0.1f : 1);
        });
    }
}