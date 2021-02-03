package com.hsbc.poc.cloudui.builder;

import com.hsbc.poc.cloudui.model.Firewall;

public class FirewallBuilder {

    private String name;
    private String network;
    private String source_tags;
    private String protocol;
    //private String protocol2;
    private String ports;

    public FirewallBuilder setSource_tags(String source_tags) {
        this.source_tags = source_tags;
        return this;
    }

    public FirewallBuilder setProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }


    public FirewallBuilder setPorts(String ports) {
        this.ports = ports;
        return this;
    }

    public FirewallBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public FirewallBuilder setNetwork(String network) {
        this.network = network;
        return this;
    }

    public Firewall createFireWall(){
        return new Firewall(name, network, source_tags, protocol, ports);
    }
}
