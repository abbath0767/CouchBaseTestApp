package com.luxary_team.couchbasetestapp.data.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

public final class Organization extends ParentModelObject {

    private String name;
    private Long geo;
    private Long idType;
    private String type;

    @JsonIgnore
    public static final String TYPE = "organization";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public Long getGeo() {
        return geo;
    }

    public void setGeo(Long geo) {
        this.geo = geo;
    }

    public Long getIdType() {
        return idType;
    }

    public void setIdType(Long type) {
        this.idType = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "mName='" + name + '\'' +
                ", geo=" + geo +
                ", type=" + type +
                '}';
    }
}
