package com.luxary_team.couchbasetestapp.data;


import com.couchbase.lite.CouchbaseLiteException;
import com.luxary_team.couchbasetestapp.data.model.Organization;

import java.util.List;

public interface DBServiseInteface {
    List<Organization> getOrganizations() throws CouchbaseLiteException;
}
