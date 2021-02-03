package com.hsbc.poc.cloudui.builder;

import com.hsbc.poc.cloudui.model.Mig;

public class MigBuilder {
    private String name_prefix;
    private String machine_type;
    private String[] tags;
    private String automatic_restart;
    private String on_host_maintenance;
    private String subnetwork;
    private String source;
    private String auto_delete;
    private String boot;
    private String email;
    private String[] scopes;
    private String create_before_destroy;
    private String mig_name;
    private String region;
    private String base_instance_name;
    private String target_size;
    private String wait_for_instances;
    private String[] distribution_policy_zones;
    private String version_name;
    private String instance_template;

    public MigBuilder setName_prefix(String name_prefix) {
        this.name_prefix = name_prefix;
        return this;
    }

    public MigBuilder setMachine_type(String machine_type) {
        this.machine_type = machine_type;
        return this;
    }

    public MigBuilder setTags(String[] tags) {
        this.tags = tags;
        return this;
    }

    public MigBuilder setAutomatic_restart(String automatic_restart) {
        this.automatic_restart = automatic_restart;
        return this;
    }

    public MigBuilder setOn_host_maintenance(String on_host_maintenance) {
        this.on_host_maintenance = on_host_maintenance;
        return this;
    }

    public MigBuilder setSubnetwork(String subnetwork) {
        this.subnetwork = subnetwork;
        return this;
    }

    public MigBuilder setSource(String source) {
        this.source = source;
        return this;
    }

    public MigBuilder setAuto_delete(String auto_delete) {
        this.auto_delete = auto_delete;
        return this;
    }

    public MigBuilder setBoot(String boot) {
        this.boot = boot;
        return this;
    }

    public MigBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public MigBuilder setScopes(String[] scopes) {
        this.scopes = scopes;
        return this;
    }

    public MigBuilder setCreate_before_destroy(String create_before_destroy) {
        this.create_before_destroy = create_before_destroy;
        return this;
    }

    public MigBuilder setMig_name(String mig_name) {
        this.mig_name = mig_name;
        return this;
    }

    public MigBuilder setRegion(String region) {
        this.region = region;
        return this;
    }

    public MigBuilder setBase_instance_name(String base_instance_name) {
        this.base_instance_name = base_instance_name;
        return this;
    }

    public MigBuilder setTarget_size(String target_size) {
        this.target_size = target_size;
        return this;
    }

    public MigBuilder setWait_for_instances(String wait_for_instances) {
        this.wait_for_instances = wait_for_instances;
        return this;
    }

    public MigBuilder setDistribution_policy_zones(String[] distribution_policy_zones) {
        this.distribution_policy_zones = distribution_policy_zones;
        return this;
    }

    public MigBuilder setVersion_name(String version_name) {
        this.version_name = version_name;
        return this;
    }

    public MigBuilder setInstance_template(String instance_template) {
        this.instance_template = instance_template;
        return this;
    }

    public Mig createMig() {
        return new Mig(name_prefix, machine_type, tags, automatic_restart, on_host_maintenance, subnetwork, source, auto_delete, boot, email, scopes, create_before_destroy, mig_name, region, base_instance_name, target_size, wait_for_instances, distribution_policy_zones, version_name, instance_template);
    }
}