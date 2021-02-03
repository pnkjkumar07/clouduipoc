package com.hsbc.poc.cloudui.builder;

import com.hsbc.poc.cloudui.model.NetworkInterface;

public class NetworkInterfaceBuilder {

    private String name;

    public NetworkInterfaceBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public NetworkInterface createNetworkInterface(){
        return new NetworkInterface(name);
    }
}
