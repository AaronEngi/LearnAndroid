package wang.tyrael.learnandroid.view.systemalert;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import wang.tyrael.learnandroid.MainActivity;
import wang.tyrael.learnandroid.R;

/**
 * 参考资料
 * https://developer.android.com/reference/android/view/WindowManager.LayoutParams#TYPE_APPLICATION_OVERLAY
 * https://developer.android.com/reference/android/Manifest.permission#SYSTEM_ALERT_WINDOW
 * https://developer.android.com/reference/android/provider/Settings#ACTION_MANAGE_OVERLAY_PERMISSION
 * https://www.jianshu.com/p/78953f3c07d5
 *
 * 6.0 23 M以前是静态权限
 * 8.0 26 O以后只能使用类型TYPE_APPLICATION_OVERLAY
 */
public class LearnSystemAlertActivity extends AppCompatActivity {
    TextView permissionStatusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_system_alert);
        permissionStatusView = findViewById(R.id.tv_permission_status);

        findViewById(R.id.bn_request_permission).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                            Uri.parse("package:" + getPackageName()));
                    startActivityForResult(intent, 0);
                } else {
                    Toast.makeText(LearnSystemAlertActivity.this, "23 以下不需要动态申请", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.bn_show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LearnSystemAlertActivity.this);
                builder.setTitle("模拟Toast");
                builder.setSingleChoiceItems(new String[]{"切换 Acitivty"}, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(LearnSystemAlertActivity.this, MainActivity.class));
                    }
                });
                builder.setPositiveButton("关闭窗口", null);
                builder.setCancelable(false);
                AlertDialog dialog = builder.create();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    //noinspection ConstantConditions
                    dialog.getWindow().setType((WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY));
                } else {
                    //noinspection ConstantConditions
                    dialog.getWindow().setType((WindowManager.LayoutParams.TYPE_SYSTEM_ALERT));
                }
                try {
                    dialog.show();
                } catch (WindowManager.BadTokenException e) {
                    Toast.makeText(LearnSystemAlertActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        String status;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Settings.canDrawOverlays(this)) {
                status = "已获取权限";
            } else {
                status = "未获取权限";
            }
        } else {
            status = "已获取权限";
        }
        permissionStatusView.setText(status);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Settings.canDrawOverlays(this)) {
                Toast.makeText(this, "成功获取权限", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "未获取权限", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
