package com.hsbc.poc.cloudui.model;

import java.io.Serializable;
import java.util.Arrays;

public class ComputeVM implements Serializable{

    private static final long serialVersionUID = -299482035708790407L;
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
    private LoadBalancing loadBalancing;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getScopes() {
        return scopes;
    }

    public void setScopes(String[] scopes) {
        this.scopes = scopes;
    }

    public String getNetworkInt() {
        return networkInt;
    }

    public void setNetworkInt(String networkInt) {
        this.networkInt = networkInt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public ComputeVM(String name, String zone, String machine_type, String source, String networkInt, String email, String[] scopes, String allow_stopping_for_update,
                     String tags, CloudDns cloudDns, BootDisk bootDisk, ServiceAccount serviceAccount,
                     NetworkInterface networkInterface, Firewall firewall, PersistentDisk persistentDisk,
                     SubNetwork subNetwork, Provider provider, Mig mig, DBInstance dbInstance, LoadBalancing loadBalancing) {
        this.name = name;
        this.zone = zone;
        this.machine_type = machine_type;
        this.source = source;
        this.networkInt = networkInt;
        this.email = email;
        this.scopes = scopes;
        this.allow_stopping_for_update = allow_stopping_for_update;
        this.tags = tags;
        this.bootDisk = bootDisk;
        this.serviceAccount = serviceAccount;
        this.networkInterface = networkInterface;
        this.firewall = firewall;
        this.persistentDisk = persistentDisk;
        this.cloudDns = cloudDns;
        this.subNetwork = subNetwork;
        this.provider = provider;
        this.mig = mig;
        this.dbInstance = dbInstance;
        this.loadBalancing = loadBalancing;
    }

    public ComputeVM(String name, String zone, String machine_type, String allow_stopping_for_update,
                     String source, String tags, SubNetwork subNetwork) {
        this.name = name;
        this.zone = zone;
        this.machine_type = machine_type;
        this.allow_stopping_for_update = allow_stopping_for_update;
        this.source = source;
        this.tags = tags;
        this.subNetwork = subNetwork;
    }

        public PersistentDisk getPersistentDisk() {
        return persistentDisk;
    }

    public void setPersistentDisk(PersistentDisk persistentDisk) {
        this.persistentDisk = persistentDisk;
    }

    public BootDisk getBootDisk() {
        return bootDisk;
    }

    public void setBootDisk(BootDisk bootDisk) {
        this.bootDisk = bootDisk;
    }

    public NetworkInterface getNetworkInterface() {
        return networkInterface;
    }

    public void setNetworkInterface(NetworkInterface networkInterface) {
        this.networkInterface = networkInterface;
    }

    public ServiceAccount getServiceAccount() {
        return serviceAccount;
    }

    public void setServiceAccount(ServiceAccount serviceAccount) {
        this.serviceAccount = serviceAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getMachine_type() {
        return machine_type;
    }

    public void setMachine_type(String machine_type) {
        this.machine_type = machine_type;
    }

    public String getAllow_stopping_for_update() {
        return allow_stopping_for_update;
    }

    public void setAllow_stopping_for_update(String allow_stopping_for_update) {
        this.allow_stopping_for_update = allow_stopping_for_update;
    }

    public String getDnsName() {
        return dnsName;
    }

    public void setDnsName(String dnsName) {
        this.dnsName = dnsName;
    }

    public Firewall getFirewall() {
        return firewall;
    }

    public void setFirewall(Firewall firewall) {
        this.firewall = firewall;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
    //private service_account serviceAccount;

    public ComputeVM() {
        super();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("" +
                 "\r\n ## Create a VM instance" +
                "\r\n resource \"google_compute_instance\" \"cloud_ui_poc_vm\" { " +
                "\r\n name = \"" + name  + "\"" +
                "\r\n zone = \"" + zone + "\"" +
                "\r\n machine_type = \"" + machine_type + "\"" +
                "\r\n boot_disk { \r\n source = google_compute_disk.t-compute-disk.self_link"  + "\r\n } " +
                "\r\n network_interface {\r\n network = google_compute_network.cloud_ui_poc_network.self_link" +  "\r\n } " +
                "\r\n service_account { \r\n email = google_service_account.src_acc_poc.email"  +
                "\r\n scopes = " + Arrays.toString(scopes) + "\r\n }"
                );
                sb.append("\r\n}");
        if(null != cloudDns){
            sb.append(cloudDns);
        }
        if(null != networkInterface) {
            sb.append(networkInterface);
        }
        if(null != subNetwork){
            sb.append(subNetwork);
        }
        if(null != serviceAccount){
            sb.append(serviceAccount);
        }
        if(null != firewall){
            sb.append(firewall);
        }
        if(null != persistentDisk){
            sb.append(persistentDisk);
        }
        if(null != provider){
            sb.append(provider);
        }
        if(null != mig){
            sb.append(mig);
        }
        if(null != dbInstance){
            sb.append(dbInstance);
        }
        if(null != loadBalancing){
            sb.append(loadBalancing);
        }
        return sb.toString();
    }
}
