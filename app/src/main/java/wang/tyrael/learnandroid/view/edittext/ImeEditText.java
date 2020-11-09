package wang.tyrael.learnandroid.view.edittext;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import wang.tyrael.learnandroid.R;

public class ImeEditText extends FrameLayout {
    TextView textView;
    EditText editText;

    public ImeEditText(@NonNull Context context) {
        super(context);
    }

    public ImeEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.ime_edit_text, this);
        textView = findViewById(R.id.textView4);
        editText = findViewById(R.id.editText);
    }

    public void onOpenKeyboard(){

    }

    public void onCloseKeyboard(){

    }


}
