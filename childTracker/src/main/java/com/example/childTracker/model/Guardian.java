package com.example.childTracker.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guardian {
    private int guardianId;
    private String firstName;
    private String lastName;
    private String relation;
    private String homePhone;
    private String workPhone;
    private String mobilePhone;
    private Address homeAddress;
    private String emailAddress;
    private Map<String, String> custodyArrangement = new HashMap<String, String>();
    private boolean livesWithStudent;

    public Guardian(){

    }

    public Guardian(String firstName, String lastName, String relation, String homePhone, String workPhone, String mobilePhone, Address homeAddress, String emailAddress, boolean livesWithStudent) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.relation = relation;
        this.homePhone = homePhone;
        this.workPhone = workPhone;
        this.mobilePhone = mobilePhone;
        this.homeAddress = homeAddress;
        this.emailAddress = emailAddress;
        this.livesWithStudent = livesWithStudent;
    }

    public int getGuardianId() {
        return guardianId;
    }

    public void setGuardianId(int guardianId) {
        this.guardianId = guardianId;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Map<String, String> getCustodyArrangement() {
        return custodyArrangement;
    }

    public void setCustodyArrangement(Map<String, String> custodyArrangement) {
        this.custodyArrangement = custodyArrangement;
    }

    public boolean doesLivesWithStudent() {
        return livesWithStudent;
    }

    public void setLivesWithStudent(boolean livesWithStudent) {
        this.livesWithStudent = livesWithStudent;
    }
}
