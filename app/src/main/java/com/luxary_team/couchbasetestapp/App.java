package com.luxary_team.couchbasetestapp;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.robotpajamas.stetho.couchbase.CouchbaseInspectorModulesProvider;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(new CouchbaseInspectorModulesProvider(this))
                        .build());
    }

    public Context getContext() {
        return getApplicationContext();
    }
}
