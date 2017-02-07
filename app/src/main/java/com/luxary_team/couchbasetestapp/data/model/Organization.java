package com.luxary_team.couchbasetestapp.data.model;


public final class Organization extends ParentModelObject {

    private String mName;
    private Long geo;
    private Long type;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Long getGeo() {
        return geo;
    }

    public void setGeo(Long geo) {
        this.geo = geo;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "mName='" + mName + '\'' +
                ", geo=" + geo +
                ", type=" + type +
                '}';
    }
}
