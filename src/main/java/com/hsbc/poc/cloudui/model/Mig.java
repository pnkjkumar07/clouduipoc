package com.hsbc.poc.cloudui.model;

import java.io.Serializable;
import java.util.Arrays;

public class Mig implements Serializable {

    private static final long serialVersionUID = -299482035708790404L;
    private String name_prefix;
    private String machine_type;
    private String tags;
    private String automatic_restart;
    private String on_host_maintenance;
    private String subnetwork;
    private String source;
    private String auto_delete;
    private String boot;
    private String email;
    private String scopes;
    private String create_before_destroy;
    private String mig_name;
    private String region;
    private String base_instance_name;
    private String target_size;
    private String wait_for_instances;
    private String[] distribution_policy_zones;
    private String version_name;
    private String instance_template;

    public Mig(String name_prefix, String machine_type, String tags, String automatic_restart, String on_host_maintenance, String subnetwork, String source, String auto_delete, String boot, String email, String scopes, String create_before_destroy, String mig_name, String region, String base_instance_name, String target_size, String wait_for_instances, String[] distribution_policy_zones, String version_name, String instance_template) {
        this.name_prefix = name_prefix;
        this.machine_type = machine_type;
        this.tags = tags;
        this.automatic_restart = automatic_restart;
        this.on_host_maintenance = on_host_maintenance;
        this.subnetwork = subnetwork;
        this.source = source;
        this.auto_delete = auto_delete;
        this.boot = boot;
        this.email = email;
        this.scopes = scopes;
        this.create_before_destroy = create_before_destroy;
        this.mig_name = mig_name;
        this.region = region;
        this.base_instance_name = base_instance_name;
        this.target_size = target_size;
        this.wait_for_instances = wait_for_instances;
        this.distribution_policy_zones = distribution_policy_zones;
        this.version_name = version_name;
        this.instance_template = instance_template;
    }

    public Mig(String name_prefix, String machine_type, String tags){
        this.name_prefix = name_prefix;
        this.machine_type = machine_type;
        this.tags = tags;
    }
    public String getName_prefix() {
        return name_prefix;
    }

    public void setName_prefix(String name_prefix) {
        this.name_prefix = name_prefix;
    }

    public String getMachine_type() {
        return machine_type;
    }

    public void setMachine_type(String machine_type) {
        this.machine_type = machine_type;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getAutomatic_restart() {
        return automatic_restart;
    }

    public void setAutomatic_restart(String automatic_restart) {
        this.automatic_restart = automatic_restart;
    }

    public String getOn_host_maintenance() {
        return on_host_maintenance;
    }

    public void setOn_host_maintenance(String on_host_maintenance) {
        this.on_host_maintenance = on_host_maintenance;
    }

    public String getSubnetwork() {
        return subnetwork;
    }

    public void setSubnetwork(String subnetwork) {
        this.subnetwork = subnetwork;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAuto_delete() {
        return auto_delete;
    }

    public void setAuto_delete(String auto_delete) {
        this.auto_delete = auto_delete;
    }

    public String getBoot() {
        return boot;
    }

    public void setBoot(String boot) {
        this.boot = boot;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
    }

    public String getCreate_before_destroy() {
        return create_before_destroy;
    }

    public void setCreate_before_destroy(String create_before_destroy) {
        this.create_before_destroy = create_before_destroy;
    }

    public String getMig_name() {
        return mig_name;
    }

    public void setMig_name(String mig_name) {
        this.mig_name = mig_name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getBase_instance_name() {
        return base_instance_name;
    }

    public void setBase_instance_name(String base_instance_name) {
        this.base_instance_name = base_instance_name;
    }

    public String getTarget_size() {
        return target_size;
    }

    public void setTarget_size(String target_size) {
        this.target_size = target_size;
    }

    public String getWait_for_instances() {
        return wait_for_instances;
    }

    public void setWait_for_instances(String wait_for_instances) {
        this.wait_for_instances = wait_for_instances;
    }

    public String[] getDistribution_policy_zones() {
        return distribution_policy_zones;
    }

    public void setDistribution_policy_zones(String[] distribution_policy_zones) {
        this.distribution_policy_zones = distribution_policy_zones;
    }

    public String getVersion_name() {
        return version_name;
    }

    public void setVersion_name(String version_name) {
        this.version_name = version_name;
    }

    public String getInstance_template() {
        return instance_template;
    }

    public void setInstance_template(String instance_template) {
        this.instance_template = instance_template;
    }

    @Override
    public String toString() {
        return "\r\n # Create an instance template" +
                "\r\n resource \"google_compute_instance_template\" \"template\"  {" +
                "\r\n name_prefix = \"" + name_prefix + "\"" +
                "\r\n machine_type = \"" + machine_type + "\"" +
                "\r\n tags = [\"" + tags + "\"]" +
                "\r\n scheduling {" +
                "\r\n automatic_restart =  "+ automatic_restart +
                "\r\n on_host_maintenance=\"" + on_host_maintenance + "\" \r\n }" +
                "\r\n network_interface {  \r\n subnetwork=" + subnetwork + "\r\n }"+
                "\r\n disk { \r\n source=" + source +
                "\r\n auto_delete = " + auto_delete +
                "\r\n boot = " + boot + "\r\n }"+
                "\r\n service_account { \r\n email = " + email +
                "\r\n scopes = [\"" + scopes + "\"] \r\n }"+
                "\r\n lifecycle { \r\n create_before_destroy = " + create_before_destroy + "\r\n } \r\n  }" +
                /*"\r\n resource \"google_compute_region_instance_group_manager\" \"cloud_ui_poc_mig\" { " +
                "\r\n name = " + mig_name +
                "\r\n region = \"" + region + "\"" +
                "\r\n base_instance_name = \"" + base_instance_name + "\"" +
                "\r\n target_size = " + target_size +
                "\r\n wait_for_instances = " + wait_for_instances +
                "\r\n distribution_policy_zones = " + Arrays.toString(distribution_policy_zones) +
                "\r\n version { " +
                "\r\n name = \"" + version_name + "\"" +
                "\r\n instance_template = " + instance_template + "\r\n }" +
                "\r\n lifecycle { \r\n create_before_destroy = " + create_before_destroy + "\r\n }" +*/
                "\r\n }";
    }
}
