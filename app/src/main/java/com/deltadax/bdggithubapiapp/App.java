package com.deltadax.bdggithubapiapp;

import com.facebook.stetho.Stetho;
import com.orm.SugarApp;

/**
 * Created by JosePablo on 16/08/17.
 */

public class App extends SugarApp {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
