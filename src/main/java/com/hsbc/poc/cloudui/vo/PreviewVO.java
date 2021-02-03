package com.hsbc.poc.cloudui.vo;

import com.hsbc.poc.cloudui.model.*;

public class PreviewVO {

    private ServiceAccount serviceAccount;
    private NetworkInterface networkInterface;
    private SubNetwork subNetwork;
    private Firewall firewall;
    private PersistentDisk persistentDisk;
    private Provider provider;
    private ComputeVM computeVM;
    private BootDisk bootDisk;
    private CloudDns cloudDns;

    public CloudDns getCloudDns() {
        return cloudDns;
    }

    public void setCloudDns(CloudDns cloudDns) {
        this.cloudDns = cloudDns;
    }

    public ServiceAccount getServiceAccount() {
        return serviceAccount;
    }

    public void setServiceAccount(ServiceAccount serviceAccount) {
        this.serviceAccount = serviceAccount;
    }

    public NetworkInterface getNetworkInterface() {
        return networkInterface;
    }

    public void setNetworkInterface(NetworkInterface networkInterface) {
        this.networkInterface = networkInterface;
    }

    public SubNetwork getSubNetwork() {
        return subNetwork;
    }

    public void setSubNetwork(SubNetwork subNetwork) {
        this.subNetwork = subNetwork;
    }

    public Firewall getFirewall() {
        return firewall;
    }

    public void setFirewall(Firewall firewall) {
        this.firewall = firewall;
    }

    public PersistentDisk getPersistentDisk() {
        return persistentDisk;
    }

    public void setPersistentDisk(PersistentDisk persistentDisk) {
        this.persistentDisk = persistentDisk;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public ComputeVM getComputeVM() {
        return computeVM;
    }

    public void setComputeVM(ComputeVM computeVM) {
        this.computeVM = computeVM;
    }

    public BootDisk getBootDisk() {
        return bootDisk;
    }

    public void setBootDisk(BootDisk bootDisk) {
        this.bootDisk = bootDisk;
    }
}
