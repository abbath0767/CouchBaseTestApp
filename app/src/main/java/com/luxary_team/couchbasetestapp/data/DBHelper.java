package com.luxary_team.couchbasetestapp.data;

import android.content.Context;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Document;
import com.couchbase.lite.Emitter;
import com.couchbase.lite.Manager;
import com.couchbase.lite.Mapper;
import com.couchbase.lite.QueryEnumerator;
import com.couchbase.lite.QueryRow;
import com.couchbase.lite.View;
import com.couchbase.lite.android.AndroidContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luxary_team.couchbasetestapp.data.model.Organization;
import com.luxary_team.couchbasetestapp.util.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBHelper implements DBServiceInterface {

    private final static String TYPE = "type";
    private final static String ID = "_id";
    private final static String REV = "_rev";
    private final static String QUERY_ORGANIZATIONS = "app/organizations";
    private final static String QUERY_ORGANIZATIONS_VERSION = "1";

    private static DBHelper instance;

    private Database mDatabase;

    private DBHelper(final Context context) throws IOException, CouchbaseLiteException {
        Manager manager = new Manager(new AndroidContext(context), Manager.DEFAULT_OPTIONS);
        mDatabase = DBCreator.getDb(context);
    }

    public static DBHelper getInstance(final Context context) throws IOException, CouchbaseLiteException {
        if (instance == null)
            instance = new DBHelper(context);

        return instance;
    }

    @Override
    public List<Organization> getOrganizations() throws CouchbaseLiteException {
        View view = mDatabase.getView(QUERY_ORGANIZATIONS);
        if (view.getMap() == null) {
            view.setMap(new Mapper() {
                            @Override
                            public void map(Map<String, Object> document, Emitter emitter) {
                                if (document.get(TYPE).equals(Organization.TYPE)) {
                                    emitter.emit(document.get(ID), null);
                                }
                            }
                        }
                    , QUERY_ORGANIZATIONS_VERSION);
        }

        QueryEnumerator organizationQuery = view.createQuery().run();

        final List<Organization> organizationList = new ArrayList<>();
        for (QueryRow row: organizationQuery) {
            Document document = row.getDocument();
            Organization organization = modelForDocument(document, Organization.class);

            organizationList.add(organization);
        }

        return organizationList;
    }

    @Override
    public void saveOrganization(Organization organization) throws CouchbaseLiteException {
        Logger.log("save org: " + organization.toString());
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> props = mapper.convertValue(organization, Map.class);
        String id = (String) props.get("_id");

        Document doc;

        if (id == null) {
            doc = mDatabase.createDocument();
        } else {
            doc = mDatabase.getExistingDocument(id);
            if (doc == null) {
                doc = mDatabase.getDocument(id);
            } else {
                props.put(REV, doc.getProperty(REV));
            }
        }

        doc.putProperties(props);
    }

    public static <T> T modelForDocument(Document document, Class<T> aClass) {
        ObjectMapper m = new ObjectMapper();
        return m.convertValue(document.getProperties(), aClass);
    }
}
