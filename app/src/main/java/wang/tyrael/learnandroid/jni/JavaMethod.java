package wang.tyrael.learnandroid.jni;

import android.util.Log;

@SuppressWarnings("unused")
public class JavaMethod {
    public void testLong(long l) {
        Log.d("tyraelTag", "testLong() called with: l = [" + l + "]");
    }
}
