package com.hsbc.poc.cloudui.util.jenkinsobj;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Parameters {

    @JsonProperty("TF_PATH")
    String tF_PATH;

    public String getTF_PATH() {
        return this.tF_PATH;
    }
    public void setTF_PATH(String tF_PATH) {
        this.tF_PATH = tF_PATH;
    }

    @Override
    public String toString() {
        return "{" +
                "tF_PATH='" + tF_PATH + '\'' +
                '}';
    }
}
