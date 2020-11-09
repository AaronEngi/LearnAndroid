package wang.tyrael.learnandroid.view.keyboard;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class KeyBoardUtil {
    public static void openSoftKeyboard(View view) {
        if (view == null)
            return;

        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm == null)
            return;
        imm.showSoftInput(view, 0);
    }

    public static void closeSoftKeyboard(View view) {
        if (view == null)
            return;
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm == null)
            return;
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
