package wang.tyrael.learnandroid.view.edittext;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

import wang.tyrael.learnandroid.databinding.ActivityEditTextFocusBinding;

/**
 * 用一个fake textview和editText切换visibility是比较稳妥的解决方案。
 */
public class EditTextFocusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityEditTextFocusBinding viewBinding = ActivityEditTextFocusBinding.inflate(LayoutInflater.from(this));
        setContentView(viewBinding.getRoot());

        viewBinding.focusSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //todo remove this before commit
                Log.w("tyraelTag", "onCheckedChanged() called with: compoundButton = [" + compoundButton + "], b = [" + b + "]");
                if (b) {
//                    viewBinding.editTextTextPersonName.clearFocus();
                    viewBinding.editTextTextPersonName.setInputType(InputType.TYPE_NULL);
                } else {
//                    viewBinding.editTextTextPersonName.requestFocus();
                    viewBinding.editTextTextPersonName.setInputType(InputType.TYPE_CLASS_TEXT);
                }
            }
        });

    }
}