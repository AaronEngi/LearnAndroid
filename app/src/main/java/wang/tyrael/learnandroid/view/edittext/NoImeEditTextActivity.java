package wang.tyrael.learnandroid.view.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

import wang.tyrael.learnandroid.R;
import wang.tyrael.learnandroid.view.keyboard.KeyBoardUtil;

public class NoImeEditTextActivity extends AppCompatActivity {
    NoImeEditText editText;
    TextView testWatchTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_ime_edit_text);
        editText = findViewById(R.id.noImeEditText);
        testWatchTextView = findViewById(R.id.tv_test_watch);
        Switch switchIme = findViewById(R.id.switch_ime);
        switchIme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editText.setImeAllowed(isChecked);
            }
        });
        findViewById(R.id.bn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                editText.getText().append((char) new Random().nextInt(128));

                char randomChar = (char) (new Random().nextInt('z' - 'a') + 'a');
                editText.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, randomChar));
                testWatchTextView.setText(String.valueOf(randomChar));
            }
        });
        findViewById(R.id.bn_open_keyboard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyBoardUtil.openSoftKeyboard(editText);
            }
        });
        findViewById(R.id.bn_close_keyboard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyBoardUtil.closeSoftKeyboard(editText);
            }
        });

        editText.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //todo do not commit
                Log.d("tyraelTag", this + "--" + "onGlobalLayout() called");
            }
        });

        testWatchTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //todo do not commit
                Log.d("tyraelTag", this + "--" + "afterTextChanged() called with: s = [" + s + "]");
            }
        });
    }
}
