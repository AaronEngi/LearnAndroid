package wang.tyrael.learnandroid;

import android.util.Log;

public class LogUtils {
    public static void logStackTrace() {
        StackTraceElement[] stackTraceElements = (new Throwable()).getStackTrace();
        Log.d("tyraelTag ", "--" + "logStackTrace() called ****************************");
        for (int i = 0; i < stackTraceElements.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElements[i];
//todo remove before push
            Log.d("tyraelTag ", "index=" + i + "----------------------------------");
            Log.d("tyraelTag ", "className=" + stackTraceElement.getClassName());
            Log.d("tyraelTag ", "methodName=" + stackTraceElement.getMethodName());
            Log.d("tyraelTag ", "lineNumber=" + stackTraceElement.getLineNumber());
        }
        Log.d("tyraelTag ", "--" + "logStackTrace() end ****************************");
    }

}
