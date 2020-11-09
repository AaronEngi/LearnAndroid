package wang.tyrael.learnandroid.view.edittext;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.widget.AppCompatEditText;

public class NoImeEditText extends AppCompatEditText {
    private boolean isImeAllowed;

    public NoImeEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * This method is called before keyboard appears when text is selected.
     * So just hide the keyboard
     */
    @Override
    public boolean onCheckIsTextEditor() {
        if (!isImeAllowed){
            hideKeyboard();
        }
        return super.onCheckIsTextEditor();
    }

    /**
     * This methdod is called when text selection is changed, so hide keyboard to prevent it to appear
     */
    @Override
    protected void onSelectionChanged(int selStart, int selEnd) {
        super.onSelectionChanged(selStart, selEnd);
        if (!isImeAllowed){
            hideKeyboard();
        }
    }

    private void hideKeyboard(){
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getWindowToken(), 0);
    }

    public void setImeAllowed(boolean imeAllowed) {
        isImeAllowed = imeAllowed;
    }
}
