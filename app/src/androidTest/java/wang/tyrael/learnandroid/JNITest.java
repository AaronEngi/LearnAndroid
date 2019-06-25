package wang.tyrael.learnandroid;

import android.util.Log;

import androidx.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import wang.tyrael.learnandroid.jni.JNI;

@RunWith(AndroidJUnit4.class)
public class JNITest {
    @Test
    public void stringFromJNI() {
        JNI jni = new JNI();
        System.out.println(jni.stringFromJNI());
        //todo remove before push
        Log.d("tyraelTag", "stringFromJNI() called:" + jni.stringFromJNI());
    }

}
