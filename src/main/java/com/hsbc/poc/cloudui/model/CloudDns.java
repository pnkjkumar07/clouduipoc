package com.hsbc.poc.cloudui.model;

import java.io.Serializable;
import java.util.Arrays;

public class CloudDns implements Serializable {

    private static final long serialVersionUID = -299482035708790408L;

    private String managed_name;
    private String managed_dns_name;
    private String name;
    private String managed_zone;
    private String type;
    private String[] rrdatas;
    private String ttl;

    public CloudDns(String managed_name, String managed_dns_name, String name, String managed_zone, String type, String rrdatas[], String ttl) {
        this.managed_name = managed_name;
        this.managed_dns_name = managed_dns_name;
        this.name = name;
        this.managed_zone = managed_zone;
        this.type = type;
        this.rrdatas = rrdatas;
        this.ttl = ttl;
    }

    @Override
    public String toString() {
        return "\r\n # Create a Cloud DNS" +
                "\r\n resource \"google_dns_managed_zone\" \"example\" { " +
                "\r\n name = \""+managed_name + "\"" +
                "\r\n dns_name = \""+managed_dns_name + "\" \r\n }" +
                "\r\n resource \"google_dns_record_set\" \"example\" {" +
                "\r\n managed_zone =" + managed_zone  +
                "\r\n name = \"" + name + "\"" +
                "\r\n type = \"" + type + "\"" +
                "\r\n rrdatas = " + Arrays.toString(rrdatas) +
                "\r\n ttl = " + ttl +
                "\r\n}";
    }

    public String getManaged_name() {
        return managed_name;
    }

    public void setManaged_name(String managed_name) {
        this.managed_name = managed_name;
    }

    public String getManaged_dns_name() {
        return managed_dns_name;
    }

    public void setManaged_dns_name(String managed_dns_name) {
        this.managed_dns_name = managed_dns_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManaged_zone() {
        return managed_zone;
    }

    public void setManaged_zone(String managed_zone) {
        this.managed_zone = managed_zone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getRrdatas() {
        return rrdatas;
    }

    public void setRrdatas(String[] rrdatas) {
        this.rrdatas = rrdatas;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }
}
