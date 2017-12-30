package ru.gumrf.mobileapp.gumrf;

import android.app.Application;
import android.util.Log;

/**
 * Created by romanzonov on 30.12.2017.
 */

public class Singleton {
    private static Singleton mInstance;

    public static final int WEEK_CHISLITEL = 0;
    public static final int WEEK_ZNAMENATEL = 1;
    public static Singleton getInstance() {
        Log.w("DEBUG", "Singleton::getInstance()");
        if (mInstance == null) {
            mInstance = new Singleton();
        }
        return mInstance;
    }

    private Singleton() {
        Log.w("MY_TAG", "Singleton::MySingleton()");
    }

    public int getWeek() {
        return WEEK_ZNAMENATEL;
    }
}
