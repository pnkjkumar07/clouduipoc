package com.hsbc.poc.cloudui.util.jenkinsobj;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Scm{

    @JsonProperty("changes")
    List<Object> changes;

    @JsonProperty("culprits")
    List<Object> culprits;

    public List<Object> getChanges() {
        return this.changes;
    }
    public void setChanges(List<Object> changes) {
        this.changes = changes;
    }

    public List<Object> getCulprits() {
        return this.culprits;
    }
    public void setCulprits(List<Object> culprits) {
        this.culprits = culprits;
    }

    @Override
    public String toString() {
        return "{" +
                "changes=" + changes +
                ", culprits=" + culprits +
                '}';
    }
}
