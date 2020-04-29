package wang.tyrael.learnandroid;

import android.app.Application;

public class LearnApplication extends Application {
    private static LearnApplication learnApplication;

    public static LearnApplication get(){
        return learnApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        learnApplication = this;
    }


}
