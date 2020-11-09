package wang.tyrael.learnandroid.view.background;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;

import android.content.Context;
import android.os.Bundle;

import android.view.View;

import wang.tyrael.learnandroid.R;

public class LearnBackgroundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lean_background);
        findViewById(R.id.bn_show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(LearnBackgroundActivity.this, R.style.LearnBackgoundBlue);
                AlertDialog.Builder builder = new AlertDialog.Builder(contextThemeWrapper);
                builder.setTitle("背景对话框");
                builder.setView(R.layout.activity_lean_background);
                builder.create().show();
            }
        });
    }
}