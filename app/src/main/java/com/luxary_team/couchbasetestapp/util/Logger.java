package com.luxary_team.couchbasetestapp.util;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class Logger {

    private static String TAG = "MY DEBUG TAG";

    private Context mContext;
    private static Logger instance;

    private Logger(Context context) {
        mContext = context;
    }

    public static Logger getInstance(Context context) {
        if (instance == null)
            instance = new Logger(context);

        return instance;
    }

    public static void log(String message) {
        Log.d(TAG, message);
    }

    public void logWithToast(String message) {
        log(message);
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }
}
