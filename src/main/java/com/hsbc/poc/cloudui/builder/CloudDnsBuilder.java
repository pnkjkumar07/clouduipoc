package com.hsbc.poc.cloudui.builder;

import com.hsbc.poc.cloudui.model.CloudDns;

public class CloudDnsBuilder {

    private String name;
    private String managed_zone;
    private String type;
    private String[] rrdatas;
    private String ttl;
    private String managed_name;
    private String managed_dns_name;

    public CloudDnsBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CloudDnsBuilder setManaged_zone(String managed_zone) {
        this.managed_zone = managed_zone;
        return this;
    }

    public CloudDnsBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public CloudDnsBuilder setTtl(String ttl) {
        this.ttl = ttl;
        return this;
    }

    public CloudDns createCloudDns(){
        return new CloudDns(managed_name, managed_dns_name, name, managed_zone, type, rrdatas, ttl);
    }

    public CloudDnsBuilder setManaged_name(String managed_name) {
        this.managed_name = managed_name;
        return this;
    }

    public CloudDnsBuilder setManaged_dns_name(String managed_dns_name) {
        this.managed_dns_name = managed_dns_name;
        return this;
    }

    public CloudDnsBuilder setRrdatas(String[] rrdatas) {
        this.rrdatas = rrdatas;
        return this;
    }
}
