package com.hsbc.poc.cloudui.model;

import java.io.Serializable;

public class NetworkInterface implements Serializable {

    private static final long serialVersionUID = -299482035708790403L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NetworkInterface(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\r\n ## Create a VPC network " +
                "\r\n resource \"google_compute_network\" \"cloud_ui_poc_network\"  {" +
                "\r\n name =  \"" + name +"\"" +
                "\r\n}";
    }
}