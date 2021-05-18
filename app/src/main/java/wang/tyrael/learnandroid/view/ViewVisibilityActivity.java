package wang.tyrael.learnandroid.view;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

import wang.tyrael.learnandroid.databinding.ActivityViewVisibilityBinding;

public class ViewVisibilityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityViewVisibilityBinding binding = ActivityViewVisibilityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.parentSwitch.setChecked(true);
        binding.parentSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                binding.parentLayout.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            }
        });
        binding.childSwitch.setChecked(true);
        binding.childSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                binding.childView.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            }
        });
    }
}