package wang.tyrael.learnandroid.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import wang.tyrael.learnandroid.databinding.SizedRightDrawableTextViewBinding;

public class SizedRightDrawableTextView2 extends FrameLayout {
    private final SizedRightDrawableTextViewBinding viewBinding;


    public SizedRightDrawableTextView2(@NonNull Context context) {
        this(context, null);
    }

    public SizedRightDrawableTextView2(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        viewBinding = SizedRightDrawableTextViewBinding.inflate(LayoutInflater.from(context), this, true);

        String text = attrs.getAttributeValue("http://schemas.android.com/apk/res/android", "text");
        //todo remove before commit
        Log.d("tyraelTag", "" + this + " " + "SizedRightDrawableTextView2() called with: text = [" + text + "]");

        viewBinding.textView.setText(text);
    }


}
