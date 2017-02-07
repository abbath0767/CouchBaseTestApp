package com.luxary_team.couchbasetestapp.util;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class Logger {

    private static String TAG = "MY DEBUG TAG";

    public static void log(String message) {
        Log.d(TAG, message);
    }

    public static void logWithToast(String message, Context context) {
        log(message);
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
