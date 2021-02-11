package com.hsbc.poc.cloudui.model;

import java.io.Serializable;

public class DBInstance implements Serializable {

    private static final long serialVersionUID = -299482035708790406L;
    private String dbinstancename;
    private String dbversion;
    private String tier;
    private String deletion_protection;
    private String sqldbname;
    private String sqldbinstance;
    private String passwordlength;
    private String passwordspecial;
    private String passwordoverridespecial;
    private String sqlusername;
    private String sqluserinstance;
    private String sqluserhost;
    private String sqluserpassword;

    public DBInstance(String dbinstancename, String dbversion, String tier, String deletion_protection, String sqldbname, String sqldbinstance, String passwordlength, String passwordspecial, String passwordoverridespecial, String sqlusername, String sqluserinstance, String sqluserhost, String sqluserpassword) {
        this.dbinstancename = dbinstancename;
        this.dbversion = dbversion;
        this.tier = tier;
        this.deletion_protection = deletion_protection;
        this.sqldbname = sqldbname;
        this.sqldbinstance = sqldbinstance;
        this.passwordlength = passwordlength;
        this.passwordspecial = passwordspecial;
        this.passwordoverridespecial = passwordoverridespecial;
        this.sqlusername = sqlusername;
        this.sqluserinstance = sqluserinstance;
        this.sqluserhost = sqluserhost;
        this.sqluserpassword = sqluserpassword;
    }

    public DBInstance(String dbinstancename, String dbversion, String tier){
        this.dbinstancename = dbinstancename;
        this.dbversion = dbversion;
        this.tier = tier;
    }
    @Override
    public String toString() {
        return "\r\n # Create a SQL Database and DB instance" +
                "\r\n resource \"google_sql_database_instance\" \"db_instance\" {" +
                //TODO
                "\r\n name = \"" + dbinstancename + "\"" + //postgresmaster13 dbinstancename
                "\r\n database_version = \"" + dbversion + "\" \r\n " +
                "\r\n timeouts { \r\n create = \"15m\" \r\n delete = \"15m\" \r\n }"  +
                "\r\n settings { \r\n tier = \"" + tier + "\" \r\n }" +
                "\r\n deletion_protection = \"" + deletion_protection + "\" \r\n }" +
                //"\r\n timeouts { \r\n create =  = \"15m\" \r\n delete = \"15m\" \r\n }"  +
                "\r\n resource \"google_sql_database\" \"database\" { \r\n name = \"" + sqldbname + "\"" +
                "\r\n timeouts { \r\n create = \"15m\" \r\n delete = \"15m\" \r\n }"  +
                "\r\n instance=" + sqldbinstance + "\r\n }" +
                "\r\n resource \"random_password\" \"password\" { \r\n length = " + passwordlength +
                "\r\n special = " + passwordspecial +
                "\r\n override_special = \"" + passwordoverridespecial + "\" \r\n }" +
                "\r\n resource \"google_sql_user\" \"users\" { \r\n name = \"" + sqlusername + "\"" +
                "\r\n instance = " + sqluserinstance +
                "\r\n host = \"" + sqluserhost + "\"" +
                "\r\n password = " + sqluserpassword +
                "\r\n }";
    }

    public String getDbinstancename() {
        return dbinstancename;
    }

    public void setDbinstancename(String dbinstancename) {
        this.dbinstancename = dbinstancename;
    }

    public String getDbversion() {
        return dbversion;
    }

    public void setDbversion(String dbversion) {
        this.dbversion = dbversion;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getDeletion_protection() {
        return deletion_protection;
    }

    public void setDeletion_protection(String deletion_protection) {
        this.deletion_protection = deletion_protection;
    }

    public String getSqldbname() {
        return sqldbname;
    }

    public void setSqldbname(String sqldbname) {
        this.sqldbname = sqldbname;
    }

    public String getSqldbinstance() {
        return sqldbinstance;
    }

    public void setSqldbinstance(String sqldbinstance) {
        this.sqldbinstance = sqldbinstance;
    }

    public String getPasswordlength() {
        return passwordlength;
    }

    public void setPasswordlength(String passwordlength) {
        this.passwordlength = passwordlength;
    }

    public String getPasswordspecial() {
        return passwordspecial;
    }

    public void setPasswordspecial(String passwordspecial) {
        this.passwordspecial = passwordspecial;
    }

    public String getPasswordoverridespecial() {
        return passwordoverridespecial;
    }

    public void setPasswordoverridespecial(String passwordoverridespecial) {
        this.passwordoverridespecial = passwordoverridespecial;
    }

    public String getSqlusername() {
        return sqlusername;
    }

    public void setSqlusername(String sqlusername) {
        this.sqlusername = sqlusername;
    }

    public String getSqluserinstance() {
        return sqluserinstance;
    }

    public void setSqluserinstance(String sqluserinstance) {
        this.sqluserinstance = sqluserinstance;
    }

    public String getSqluserhost() {
        return sqluserhost;
    }

    public void setSqluserhost(String sqluserhost) {
        this.sqluserhost = sqluserhost;
    }

    public String getSqluserpassword() {
        return sqluserpassword;
    }

    public void setSqluserpassword(String sqluserpassword) {
        this.sqluserpassword = sqluserpassword;
    }
}
