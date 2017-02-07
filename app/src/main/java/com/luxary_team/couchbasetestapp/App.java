package com.luxary_team.couchbasetestapp;

import android.app.Application;

import com.couchbase.lite.CouchbaseLiteException;
import com.facebook.stetho.Stetho;
import com.luxary_team.couchbasetestapp.data.DBCreator;
import com.luxary_team.couchbasetestapp.util.Logger;
import com.robotpajamas.stetho.couchbase.CouchbaseInspectorModulesProvider;

import java.io.IOException;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(new CouchbaseInspectorModulesProvider(this))
                        .build());

        try {
            createDB();
        }catch (IOException | CouchbaseLiteException e) {
            e.printStackTrace();
            Logger.log("error:\n" + e.toString());
        }
    }

    private void createDB() throws IOException, CouchbaseLiteException {
        if (DBCreator.dbNotCreated(getApplicationContext())) {
            DBCreator.createNewDB(getApplicationContext());
        }
    }
}
