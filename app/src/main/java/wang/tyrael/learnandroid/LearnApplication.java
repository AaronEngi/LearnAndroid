package wang.tyrael.learnandroid;

import androidx.multidex.MultiDexApplication;

public class LearnApplication extends MultiDexApplication {
    private static LearnApplication learnApplication;

    public static LearnApplication get() {
        return learnApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        learnApplication = this;
    }


}
