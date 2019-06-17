package wang.tyrael.learnandroid;

public class StorageItem {
    public String path;
    public int type = 0;
    public boolean mounted = false;
    public long availableSize;

    @Override
    public String toString() {
        return "StorageItem{" +
                "path='" + path + '\'' +
                ", type=" + type +
                ", mounted=" + mounted +
                ", availableSize=" + availableSize +
                '}';
    }
}
