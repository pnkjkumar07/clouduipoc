package com.hsbc.poc.cloudui.builder;

import com.hsbc.poc.cloudui.model.SubNetwork;

public class SubNetworkBuilder {

    private String name;
    private String ip_cidr_range;
    private String network;
    private String region;

    public SubNetworkBuilder setRegion(String region) {
        this.region = region;
        return this;
    }

    public SubNetworkBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SubNetworkBuilder setIp_cidr_range(String ip_cidr_range) {
        this.ip_cidr_range = ip_cidr_range;
        return this;
    }

    public SubNetworkBuilder setNetwork(String network) {
        this.network = network;
        return this;
    }

    public SubNetwork createSubNetwork(){
        return new SubNetwork(name, ip_cidr_range, region);
    }
}
