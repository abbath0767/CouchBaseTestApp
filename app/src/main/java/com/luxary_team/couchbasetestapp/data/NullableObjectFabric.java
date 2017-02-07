package com.luxary_team.couchbasetestapp.data;

import com.luxary_team.couchbasetestapp.data.model.Contact;
import com.luxary_team.couchbasetestapp.data.model.Organization;


public final class NullableObjectFabric {

    public static Object getNullObject(Class clazz) {

        //todo make nullable constructors
        if (clazz.equals(Contact.class))
            return new Contact();
        else if (clazz.equals(Organization.class))
            return new Organization();
        else
            return null;
    }
}
