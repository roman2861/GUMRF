package ru.gumrf.mobileapp.gumrf;

import android.app.Application;

/**
 * Created by romanzonov on 30.12.2017.
 */

public class InitSingleton extends Application {

    public void onCreate() {
        super.onCreate();
        Singleton.getInstance();
    }

}
