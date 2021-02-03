package com.hsbc.poc.cloudui.builder;

import com.hsbc.poc.cloudui.model.DBInstance;

public class DBInstanceBuilder {
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

    public DBInstanceBuilder setDbinstancename(String dbinstancename) {
        this.dbinstancename = dbinstancename;
        return this;
    }

    public DBInstanceBuilder setDbversion(String dbversion) {
        this.dbversion = dbversion;
        return this;
    }

    public DBInstanceBuilder setTier(String tier) {
        this.tier = tier;
        return this;
    }

    public DBInstanceBuilder setDeletion_protection(String deletion_protection) {
        this.deletion_protection = deletion_protection;
        return this;
    }

    public DBInstanceBuilder setSqldbname(String sqldbname) {
        this.sqldbname = sqldbname;
        return this;
    }

    public DBInstanceBuilder setSqldbinstance(String sqldbinstance) {
        this.sqldbinstance = sqldbinstance;
        return this;
    }

    public DBInstanceBuilder setPasswordlength(String passwordlength) {
        this.passwordlength = passwordlength;
        return this;
    }

    public DBInstanceBuilder setPasswordspecial(String passwordspecial) {
        this.passwordspecial = passwordspecial;
        return this;
    }

    public DBInstanceBuilder setPasswordoverridespecial(String passwordoverridespecial) {
        this.passwordoverridespecial = passwordoverridespecial;
        return this;
    }

    public DBInstanceBuilder setSqlusername(String sqlusername) {
        this.sqlusername = sqlusername;
        return this;
    }

    public DBInstanceBuilder setSqluserinstance(String sqluserinstance) {
        this.sqluserinstance = sqluserinstance;
        return this;
    }

    public DBInstanceBuilder setSqluserhost(String sqluserhost) {
        this.sqluserhost = sqluserhost;
        return this;
    }

    public DBInstanceBuilder setSqluserpassword(String sqluserpassword) {
        this.sqluserpassword = sqluserpassword;
        return this;
    }

    public DBInstance createDBInstance() {
        return new DBInstance(dbinstancename, dbversion, tier, deletion_protection, sqldbname, sqldbinstance, passwordlength, passwordspecial, passwordoverridespecial, sqlusername, sqluserinstance, sqluserhost, sqluserpassword);
    }
}