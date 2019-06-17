package wang.tyrael.learnandroid;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;

import com.google.common.base.Strings;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StorageUtils {
    public static final int TYPE_INTERNAL_STORAGE = 1;
    public static final int TYPE_SDCARD = 2;
    public static final int TYPE_USB_STORAGE = 3;
    private static final String TAG = "StorageUtils";

    public static String getAllStorageInfoString() {
        List<StorageItem> storageInfo = StorageUtils.getAllStorageInfo();
        StringBuilder stringBuilder = new StringBuilder("storageInfo");
        for (StorageItem item : storageInfo) {
            stringBuilder.append(item);
        }
        return stringBuilder.toString();
    }

    public static boolean isInternalStorageMounted() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }

    public static String getInternalStoragePath() {
        File file = Environment.getExternalStorageDirectory();
        if (file == null) {
            return null;
        }
        return file.getPath();
    }

    private static boolean checkFsWritable(String dir) {

        if (dir == null)
            return false;

        if (!dir.endsWith(File.separator)) {
            dir = dir + File.separator;
        }

        File directory = new File(dir);

        if (!directory.isDirectory()) {
            if (!directory.mkdirs()) {
                return false;
            }
        }

        File f = new File(directory, ".zoomflajfalsfka");
        try {
            if (f.exists()) {
                f.delete();
            }
            if (!f.createNewFile()) {
                return false;
            }
            f.delete();
            return true;

        } catch (Exception e) {
        }
        return false;

    }


    public static List<StorageItem> getAllStorageInfo() {
        List<StorageItem> storageList = new ArrayList<StorageItem>();

        List<String> paths = getAllExternalStoragePaths();
        StorageItem interStorage = new StorageItem();
        interStorage.path = getInternalStoragePath();
        interStorage.type = TYPE_INTERNAL_STORAGE;
        interStorage.mounted = isInternalStorageMounted();
        interStorage.availableSize = getAvailableMemSize(interStorage.path);
        storageList.add(interStorage);

        for (String path : paths) {
            boolean mount = checkFsWritable(path);
            StorageItem item = new StorageItem();
            String lowerPath = path.toLowerCase(Locale.US);

            if (isUsbStorage(lowerPath)) {
                item.type = TYPE_USB_STORAGE;
            } else {
                item.type = TYPE_SDCARD;
            }

            item.path = path;
            item.mounted = mount;
            item.availableSize = getAvailableMemSize(path);
            storageList.add(item);
        }

        return storageList;
    }

    private static boolean isUsbStorage(String path) {
        if (Strings.isNullOrEmpty(path)) {
            return false;
        }

        String tmp = path.toLowerCase(Locale.US);
        //	if(tmp.contains("usbstorage") || tmp.contains("usbdrive") || tmp.contains("usbotg")){
        if (tmp.contains("usb")) {
            return true;
        }

        return false;
    }

    private static List<String> getAllExternalStoragePaths() {
        List<String> storagePaths = new ArrayList<String>();
        Runtime runtime = Runtime.getRuntime();
        Process proc = null;
        try {
            proc = runtime.exec("mount");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (proc == null)
            return storagePaths;
        InputStream is = proc.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        try {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("secure")
                        || line.contains("asec") || line.contains("media")
                        || line.contains("system") || line.contains("cache")
                        || line.contains("sys") || line.contains("data")
                        || line.contains("tmpfs") || line.contains("shell")
                        || line.contains("root") || line.contains("acct")
                        || line.contains("proc") || line.contains("misc")
                        || line.contains("obb")) {
                    continue;
                }

                if (line.contains("fat") || line.contains("fuse")
                        || (line.contains("ntfs"))) {

                    String columns[] = line.split(" ");
                    if (columns != null && columns.length > 1) {
                        if (Strings.isNullOrEmpty(columns[1])) {
                            continue;
                        }

                        String path = columns[1].replace("..", "");
                        if (!storagePaths.contains(path)
                                && (path.toLowerCase(Locale.US).contains("sd") || isUsbStorage(path))) {
                            storagePaths.add(columns[1]);
                        }

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IoUtils.closeSilently(br);
        }

        String internalStoragePath = getInternalStoragePath();
        if (storagePaths.contains(internalStoragePath)) {
            storagePaths.remove(internalStoragePath);
        }

        return storagePaths;
    }

    @SuppressLint("NewApi")
    public static long getAvailableMemSize(String path) {
        if (Strings.isNullOrEmpty(path)) {
            return 0;
        }

        StatFs stat = null;
        try {
            stat = new StatFs(path);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

        if (stat == null)
            return 0;

        long availableBytes = 0;
        if (Build.VERSION.SDK_INT < 18) {
            availableBytes = ((long) stat.getAvailableBlocks()) * stat.getBlockSize();
        } else {
            availableBytes = stat.getAvailableBytes();
        }
        return availableBytes;
    }
}
