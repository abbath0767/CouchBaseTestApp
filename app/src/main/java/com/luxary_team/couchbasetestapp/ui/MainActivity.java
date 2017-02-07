package com.luxary_team.couchbasetestapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.luxary_team.couchbasetestapp.R;
import com.luxary_team.couchbasetestapp.util.Logger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.icon_menu_add_new_org: {
                Logger.log("click ADD");
                break;
            }
            case R.id.icon_menu_sync: {
                Logger.log("click sync");
                break;
            }
            default: {
                Logger.log("default");
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
