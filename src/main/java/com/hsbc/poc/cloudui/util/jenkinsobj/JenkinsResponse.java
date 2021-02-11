package com.hsbc.poc.cloudui.util.jenkinsobj;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JenkinsResponse {

    @JsonProperty("name")
    private String name;

    @JsonProperty("display_name")
    String display_name;

    @JsonProperty("url")
    private String url;

    @JsonProperty("build")
    private Build build;

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDisplay_name() {
        return this.display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Build getBuild() {
        return this.build;
    }

    public void setBuild(Build build) {
        this.build = build;
    }
}