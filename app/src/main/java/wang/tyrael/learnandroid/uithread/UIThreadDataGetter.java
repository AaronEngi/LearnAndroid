package wang.tyrael.learnandroid.uithread;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public abstract class UIThreadDataGetter<T> {
    private static final String TAG = "MainThreadDataGetter";
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    //@GuardedBy(MainThreadDataGetter.this)
    private T data = null;

    public T get() {
        if (isMainThread()) {
            return doGet();
        }

        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                synchronized (UIThreadDataGetter.this) {
                    data = doGet();
                    this.notify();
                }
            }
        });
        synchronized (UIThreadDataGetter.this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                Log.w(TAG, "get interrupted", e);
            }
        }
        return data;
    }

    protected abstract T doGet();

    private boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}

