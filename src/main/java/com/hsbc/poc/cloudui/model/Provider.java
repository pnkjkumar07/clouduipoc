package com.hsbc.poc.cloudui.model;

import java.io.Serializable;

public class Provider implements Serializable {

    private static final long serialVersionUID = -299482035708790401L;
    private String project;
    private String region;

    public Provider(String project, String region) {
        this.project = project;
        this.region = region;
    }

    @Override
    public String toString() {
        return "\r\n ## Configure the Google Cloud Provider" +
                "\r\n provider \"google\" {" +
                "\r\n project = \"" + project +"\"" +
                "\r\n region = \"" + region +"\"" +
                "\r\n}";
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
