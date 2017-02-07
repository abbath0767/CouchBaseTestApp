package com.luxary_team.couchbasetestapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.luxary_team.couchbasetestapp.R;
import com.luxary_team.couchbasetestapp.util.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recucler_view_main_activity_organizations)
    RecyclerView mOrganizationsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mOrganizationsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

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
                return true;
            }
            case R.id.icon_menu_sync: {
                Logger.log("click sync");
                return true;
            }
            default: {
                Logger.log("default");
                return true;
            }
        }
    }
}
