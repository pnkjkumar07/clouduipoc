package com.hsbc.poc.cloudui.builder;

import com.hsbc.poc.cloudui.model.*;

public class ComputeVMBuilder {

    private String name;
    private String dnsName;
    private String zone;
    private String machine_type;
    private String allow_stopping_for_update;
    private String tags;
    private BootDisk bootDisk;
    private ServiceAccount serviceAccount;
    private NetworkInterface networkInterface;
    private Firewall firewall;
    private PersistentDisk persistentDisk;
    private CloudDns cloudDns;
    private SubNetwork subNetwork;
    private Provider provider;
    private String source;
    private String networkInt;
    private String email;
    private String[] scopes;
    private Mig mig;
    private DBInstance dbInstance;

    public ComputeVMBuilder setSource(String source) {
        this.source = source;
        return this;
    }

    public ComputeVMBuilder setNetworkInt(String networkInt) {
        this.networkInt = networkInt;
        return this;
    }

    public ComputeVMBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public ComputeVMBuilder setScopes(String[] scopes) {
        this.scopes = scopes;
        return this;
    }

    public ComputeVMBuilder setPersistentDisk(PersistentDisk persistentDisk) {
        this.persistentDisk = persistentDisk;
        return this;
    }

    public ComputeVMBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ComputeVMBuilder setDnsName(String dnsName) {
        this.dnsName = dnsName;
        return this;
    }

    public ComputeVMBuilder setZone(String zone) {
        this.zone = zone;
        return this;
    }

    public ComputeVMBuilder setMachine_type(String machine_type) {
        this.machine_type = machine_type;
        return this;
    }

    public ComputeVMBuilder setAllow_stopping_for_update(String allow_stopping_for_update) {
        this.allow_stopping_for_update = allow_stopping_for_update;
        return this;
    }

    public ComputeVMBuilder setTags(String tags) {
        this.tags = tags;
        return this;
    }

    public ComputeVMBuilder withBootDisk(BootDisk bootDisk) {
        this.bootDisk = bootDisk;
        return this;
    }

    public ComputeVMBuilder withServiceAccount(ServiceAccount serviceAccount) {
        this.serviceAccount = serviceAccount;
        return this;
    }

    public ComputeVMBuilder withNetworkInterface(NetworkInterface networkInterface) {
        this.networkInterface = networkInterface;
        return this;
    }

    public ComputeVMBuilder withFireWall(Firewall fireWall){
        this.firewall = fireWall;
        return this;
    }
    public ComputeVMBuilder withPersistentDisk(PersistentDisk persistentDisk){
        this.persistentDisk = persistentDisk;
        return this;
    }

    public ComputeVMBuilder withCloudDns(CloudDns cloudDns) {
        this.cloudDns = cloudDns;
        return this;
    }

    public ComputeVMBuilder withSubNetwork(SubNetwork subNetwork) {
        this.subNetwork = subNetwork;
        return this;
    }

    public ComputeVMBuilder withProvider(Provider provider) {
        this.provider = provider;
        return this;
    }

    public ComputeVMBuilder withMig(Mig mig){
        this.mig = mig;
        return this;
    }

    public ComputeVMBuilder withDBInstance(DBInstance dbInstance){
        this.dbInstance = dbInstance;
        return this;
    }

    public ComputeVM createComputeVM() {
        return new ComputeVM(name, zone, machine_type, source, networkInt, email, scopes, allow_stopping_for_update, tags,
                cloudDns, bootDisk, serviceAccount, networkInterface, firewall, persistentDisk, subNetwork, provider, mig, dbInstance);
    }
}
