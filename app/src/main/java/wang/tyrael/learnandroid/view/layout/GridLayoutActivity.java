package wang.tyrael.learnandroid.view.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import wang.tyrael.learnandroid.R;

public class GridLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);
        final GridLayout gridLayout = findViewById(R.id.grid_layout);
        findViewById(R.id.bn_2_columns).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gridLayout.setColumnCount(2);
            }
        });
        findViewById(R.id.bn_3_columns).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gridLayout.setColumnCount(3);
            }
        });
        findViewById(R.id.bn_4_columns).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gridLayout.setColumnCount(4);
            }
        });
    }
}
