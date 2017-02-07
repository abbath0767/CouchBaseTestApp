package com.luxary_team.couchbasetestapp.data;


import android.content.Context;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.DatabaseOptions;
import com.couchbase.lite.Manager;
import com.couchbase.lite.android.AndroidContext;

import java.io.IOException;

public final class DBCreator {

    public static final String DB_NAME = "CouchBaseTest";

    public static void createNewDB(Context context) throws IOException, CouchbaseLiteException {
        DatabaseOptions options = new DatabaseOptions();
        options.setCreate(true);

        Manager manager = createManager(context);

        manager.openDatabase(DB_NAME, options);
    }

    public static boolean dbNotCreated(Context context) throws IOException, CouchbaseLiteException {

        Database database;
        Manager manager = createManager(context);

        database = manager.getExistingDatabase(DB_NAME);

        return (database == null);
    }

    public static Database getDb(Context context) throws IOException, CouchbaseLiteException {
        Manager manager = createManager(context);

        return manager.getDatabase(DB_NAME);
    }

    private static Manager createManager(Context context) throws IOException {
        return new Manager(new AndroidContext(context), Manager.DEFAULT_OPTIONS);
    }
}
