package wang.tyrael.learnandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import wang.tyrael.learnandroid.fragment.LearnDialogFragment;
import wang.tyrael.learnandroid.view.ImageViewActivity;
import wang.tyrael.learnandroid.view.ListViewActivity;
import wang.tyrael.learnandroid.view.layout.ConstraintLayoutActivity;
import wang.tyrael.learnandroid.view.layout.GridLayoutActivity;
import wang.tyrael.learnandroid.view.recyclerview.RecyclerViewGridLayoutActivity;
import wang.tyrael.learnandroid.view.systemalert.LearnSystemAlertActivity;
import wang.tyrael.learnandroid.view.toast.ToastActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bn_storagefiller).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StorageFillerActivity.class));
            }
        });
        findViewById(R.id.bn_listview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListViewActivity.class));
            }
        });
        findViewById(R.id.bn_constraintlayout).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ConstraintLayoutActivity.class));
            }
        });
        findViewById(R.id.bn_dialog_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new LearnDialogFragment();
                dialogFragment.show(getSupportFragmentManager(), "LearnDialogFragment");
            }
        });
        findViewById(R.id.bn_grid_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RecyclerViewGridLayoutActivity.class));
            }
        });
        findViewById(R.id.bn_image_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ImageViewActivity.class));
            }
        });
        findViewById(R.id.bn_grid_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GridLayoutActivity.class));
            }
        });
        setStartActivityListener(R.id.bn_toast, ToastActivity.class);
        setStartActivityListener(R.id.bn_system_alert, LearnSystemAlertActivity.class);
    }

    private void setStartActivityListener(int viewId, final Class<? extends Activity> activityToStart) {
        findViewById(viewId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, activityToStart));
            }
        });
    }

}
