package com.luxary_team.couchbasetestapp.data.model;


public final class Contact extends ParentModelObject {

    private String mFirstName;
    private String mLastName;
    private String mMiddleName;
    private String mOrganizationId;
    private Long mContactType;
    private String mLastEventDate;
    private String mEmail;
    private String mPhone;
    private Long mSpecialization;

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getMiddleName() {
        return mMiddleName;
    }

    public void setMiddleName(String middleName) {
        mMiddleName = middleName;
    }

    public String getOrganizationId() {
        return mOrganizationId;
    }

    public void setOrganizationId(String organizationId) {
        mOrganizationId = organizationId;
    }

    public Long getContactType() {
        return mContactType;
    }

    public void setContactType(Long contactType) {
        mContactType = contactType;
    }

    public String getLastEventDate() {
        return mLastEventDate;
    }

    public void setLastEventDate(String lastEventDate) {
        mLastEventDate = lastEventDate;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public Long getSpecialization() {
        return mSpecialization;
    }

    public void setSpecialization(Long specialization) {
        mSpecialization = specialization;
    }
}
