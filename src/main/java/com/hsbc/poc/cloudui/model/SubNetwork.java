package com.hsbc.poc.cloudui.model;

import java.io.Serializable;

public class SubNetwork implements Serializable {

    private static final long serialVersionUID = -29948203570879040L;
    private String name;
    private String ip_cidr_range;
    private String region;

    public SubNetwork(String name, String ip_cidr_range,  String region) {
        this.name = name;
        this.ip_cidr_range = ip_cidr_range;
        this.region = region;
    }

    @Override
    public String toString() {
        return "\r\n ## Create a subnetwork" +
                "\r\n resource \"google_compute_subnetwork\" \"cloud_ui_poc_subnetwork\" {" +
                "\r\n name = \"" + name +"\"" +
                "\r\n ip_cidr_range = \"" + ip_cidr_range +"\"" +
                "\r\n network = google_compute_network.cloud_ui_poc_network.id" +
                "\r\n region = \"" + region +"\"" +
                "\r\n }";
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp_cidr_range() {
        return ip_cidr_range;
    }

    public void setIp_cidr_range(String ip_cidr_range) {
        this.ip_cidr_range = ip_cidr_range;
    }
}
