package wang.tyrael.learnandroid;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.util.List;

//import us.zoom.androidlib.app.ZMStorageUtil;
//import us.zoom.zrc.ZRCApplication;

public class StorageFillerRunnable implements Runnable{
    private static final String TAG = "StorageFillerRunnable";
    private boolean stop;
    private final Context context;

    public StorageFillerRunnable(Context context) {
        this.context = context;
    }
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        // First, check if the class has already been loaded
//        Class<?> c = findLoadedClass(name);
//        if (c == null) {
//            try {
//                if (parent != null) {
//                    c = parent.loadClass(name, false);
//                } else {
//                    c = findBootstrapClassOrNull(name);
//                }
//            } catch (ClassNotFoundException e) {
//                // ClassNotFoundException thrown if class not found
//                // from the non-null parent class loader
//            }
//            if (c == null) {
//                // If still not found, then invoke findClass in order
//                // to find the class.
//                c = findClass(name);
//            }
//        }
//        return c;
        return null;
    }

    @Override
    public void run() {
        while (!stop){
            copyToStorage();
            logStorageInfo();
//            try {
//                sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    private void logStorageInfo() {
        List<StorageItem> storageInfo = StorageUtils.getAllStorageInfo();
        for (StorageItem item : storageInfo){
            Log.d("tyraelTag", "logStorageInfo() called:" + item);
        }
    }

    private void copyToStorage() {
//        ResRawUtils.copy(context, R.raw.test, "test" + System.currentTimeMillis(), Environment.getExternalStorageDirectory() + "/full");
    }

    public void stop(){
        stop = true;
    }

}
