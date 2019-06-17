package wang.tyrael.learnandroid;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;

public class StorageFillerActivity extends AppCompatActivity {
    StorageFillerRunnable storageFillerRunnable = new StorageFillerRunnable(this);
    Thread thread = new Thread(storageFillerRunnable);

    TextView tvLog;

    private Handler mainHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_filler);

        tvLog = findViewById(R.id.tv_log);

        findViewById(R.id.bn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storageFillerRunnable = new StorageFillerRunnable(StorageFillerActivity.this);
                thread = new Thread(storageFillerRunnable);
                thread.start();
            }
        });

        findViewById(R.id.bn_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storageFillerRunnable.stop();
            }
        });

        findViewById(R.id.bn_clean).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                FileUtil.delDir(Environment.getExternalStorageDirectory() + "/full");
                updateStorageStatus();
            }
        });

       mainHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                updateStorageStatus();
                mainHandler.postDelayed(this, 3000);
            }
        }, 3000);
    }

    void updateStorageStatus(){
        tvLog.setText( new Date()+ ":" + StorageUtils.getAllStorageInfoString());
    }
}
