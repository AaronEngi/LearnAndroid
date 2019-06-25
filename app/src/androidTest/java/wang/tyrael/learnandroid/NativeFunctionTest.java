package wang.tyrael.learnandroid;

import android.util.Log;

import androidx.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import wang.tyrael.learnandroid.jni.NativeFunction;

@RunWith(AndroidJUnit4.class)
public class NativeFunctionTest {
    @Test
    public void stringFromJNI() {
        NativeFunction aNativeFunction = new NativeFunction();
        System.out.println(aNativeFunction.stringFromJNI());
        Log.d("tyraelTag", "stringFromJNI() called:" + aNativeFunction.stringFromJNI());
    }

    @Test
    public void testLong() {
        NativeFunction nativeFunction = new NativeFunction();
        Log.d("tyraelTag", "testLong:sizeOfLong:" + nativeFunction.sizeOfLong());
        Log.d("tyraelTag", "testLong:sizeOfJlong: " + nativeFunction.sizeOfJlong());

        nativeFunction.testLong(1);
        nativeFunction.testLong(-1);
        nativeFunction.testLong(0);
        Log.d("tyraelTag", "testLong() called:" + Long.MAX_VALUE);
        nativeFunction.testLong(Long.MAX_VALUE);
        Log.d("tyraelTag", "testLong() called:" + Long.MIN_VALUE);
        nativeFunction.testLong(Long.MIN_VALUE);
        long now = System.currentTimeMillis();
        Log.d("tyraelTag", "testLong() called:" + now);
        nativeFunction.testLong(now);
    }
}
