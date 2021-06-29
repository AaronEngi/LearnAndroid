package wang.tyrael.learnandroid.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import wang.tyrael.learnandroid.databinding.SizedRightDrawableTextViewBinding;

public class SizedRightDrawableTextView extends FrameLayout {
    private final LinearLayout linearLayout;
    private SizedRightDrawableTextViewBinding viewBinding;

    public SizedRightDrawableTextView(@NonNull Context context) {
        this(context, null);
    }

    public SizedRightDrawableTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        linearLayout = new LinearLayout(context);
        addView(linearLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
//        super.addView(child, index, params);
        linearLayout.addView(child, index, params);
    }
}
