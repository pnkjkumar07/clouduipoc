package com.hsbc.poc.cloudui.util.jenkinsobj;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Build {

    @JsonProperty("full_url")
    String full_url;

    @JsonProperty("number")
    int number;

    @JsonProperty("queue_id")
    int queue_id;

    @JsonProperty("timestamp")
    long timestamp;

    @JsonProperty("phase")
    String phase;

    @JsonProperty("status")
    String status;

    @JsonProperty("url")
    String url;

    @JsonProperty("scm")
    Scm scm;

    @JsonProperty("parameters")
    Parameters parameters;

    @JsonProperty("log")
    String log;

    @JsonProperty("notes")
    String notes;

    @JsonProperty("artifacts")
    Artifacts artifacts;

    public String getFull_url() {
        return this.full_url;
    }
    public void setFull_url(String full_url) {
        this.full_url = full_url;
    }

    public int getNumber() {
        return this.number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public int getQueue_id() {
        return this.queue_id;
    }
    public void setQueue_id(int queue_id) {
        this.queue_id = queue_id;
    }

    public long getTimestamp() {
        return this.timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getPhase() {
        return this.phase;
    }
    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public Scm getScm() {
        return this.scm;
    }
    public void setScm(Scm scm) {
        this.scm = scm;
    }

    public Parameters getParameters() {
        return this.parameters;
    }
    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public String getLog() {
        return this.log;
    }
    public void setLog(String log) {
        this.log = log;
    }

    public String getNotes() {
        return this.notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Artifacts getArtifacts() {
        return this.artifacts;
    }

    public void setArtifacts(Artifacts artifacts) {
        this.artifacts = artifacts;
    }

    @Override
    public String toString() {
        return "{" +
                "full_url='" + full_url + '\'' +
                ", number=" + number +
                ", queue_id=" + queue_id +
                ", timestamp=" + timestamp +
                ", phase='" + phase + '\'' +
                ", status='" + status + '\'' +
                ", url='" + url + '\'' +
                ", scm=" + scm +
                ", parameters=" + parameters +
                ", log='" + log + '\'' +
                ", notes='" + notes + '\'' +
                ", artifacts=" + artifacts +
                '}';
    }
}