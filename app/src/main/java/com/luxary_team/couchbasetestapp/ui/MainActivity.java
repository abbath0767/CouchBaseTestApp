package com.luxary_team.couchbasetestapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.couchbase.lite.CouchbaseLiteException;
import com.luxary_team.couchbasetestapp.R;
import com.luxary_team.couchbasetestapp.data.DBHelper;
import com.luxary_team.couchbasetestapp.data.DBServiceInterface;
import com.luxary_team.couchbasetestapp.data.model.Organization;
import com.luxary_team.couchbasetestapp.util.Logger;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recucler_view_main_activity_organizations)
    RecyclerView mOrganizationsRecyclerView;

    private DBServiceInterface mDBService;
    private List<Organization> mOrganizations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();

        mOrganizationsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void init() {
        try {
            mDBService = DBHelper.getInstance(getApplicationContext());
        } catch (IOException | CouchbaseLiteException e) {
            e.printStackTrace();
            Logger.log("error with db");
        }
        loadOrganizations();
    }

    private void openDialogForNewOrganization() {
        final CreateOrganizationDialog dialog = new CreateOrganizationDialog(MainActivity.this);
        dialog.setDialogClickListener(new CreateOrganizationDialog.CreateOrgDialogListener() {
            @Override
            public void clickSave(Organization organization) {
                saveOrganizationToDB(organization);
            }
            @Override
            public void clickCancel() {
            }
        });

        dialog.show();
    }

    private void saveOrganizationToDB(final Organization organization) {
        try {
            mDBService.saveOrganization(organization);
            notifyDataChanges();
        } catch (CouchbaseLiteException e) {
            e.printStackTrace();
            Logger.log("save error with org: " + organization);
        }
    }

    private void loadOrganizations() {
        try {
            mOrganizations= mDBService.getOrganizations();
            Logger.log("Org-ion list size: " + mOrganizations.size());
        } catch (CouchbaseLiteException e) {
            e.printStackTrace();
            Logger.log("error with getting org-ion list");
        }
    }

    private void notifyDataChanges() {
        loadOrganizations();
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
                openDialogForNewOrganization();
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
