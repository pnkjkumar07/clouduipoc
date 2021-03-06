package com.hsbc.poc.cloudui.util;

import com.hsbc.poc.cloudui.builder.*;
import com.hsbc.poc.cloudui.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class GenerateFinalTerraForm {

    //private static String filePath = "C:\\develpment\\hsbc\\git\\HiteshUIRepo\\demo\\scenario_02\\";
    //private static String filePath = git_main_tf_filepath//"D:\\platformui\\demo\\scenario_02\\"; //hitesh

    @Autowired
    private static ConfigUtility configUtil;

    public static void writeToTempFile( Object computeVM) throws Exception{
        String filePath = null;
        System.out.println("configUtil = "+configUtil);
        if(null == configUtil){
            filePath = "/home/hitesh_cloudwork/decoder/servicelayer/repo/platformui/demo/scenario_02/main.tf";
        }
        else {
            filePath = configUtil.getProperty("git_main_tf_filepath");
        }

        System.out.println("FilePath to write main.tf= "+filePath);
        FileOutputStream fout = new FileOutputStream(new File((filePath)));
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(computeVM);
        oos.close();
        fout.close();
        System.out.println("Writting tf file path:- "+filePath);
        System.out.println(computeVM);

    }

    public static void main(String[] args) throws Exception{
        //createMainTF();
    }

    /*private static void createMainTF() throws Exception {
        String[] tags = {"\"web\""};
        String[] mig_tags = {"\"sample\""};
        String[] mig_scopes = {"\"storage-rw\""};
        String[] mig_distribution_policy_zones = {"\"us-central1-a\""};
        String[] scopes = {"\"cloud-platform\""};
        String[] ports = {"\"80\"", "\"8080\"", "\"1000-2000\""};
        String[] rrdatas = {"\"8.8.8.8\""};
        final ComputeVM computeVM = new ComputeVMBuilder().setName("Cloud-UI-POC").setZone("us-central1-a")
                    .setMachine_type("n1-standard-1").setSource("google_compute_disk.t-compute-disk.self_link")
                    .setNetworkInt("google_compute_network.cloud_ui_poc_network.self_link")
                    .setAllow_stopping_for_update("Yes").setEmail("google_service_account.src_acc_poc.email").setScopes(scopes)
                .withBootDisk(new BootDiskBuilder().setSource("google_compute_disk.t-compute-disk.self_link").createBootDisk())
                .withServiceAccount(new ServiceAccountBuilder().setAccount_id("cloud-ui-sa-poc").setDisplayName("POC Service Account").createServiceAccount())
                .withNetworkInterface(new NetworkInterfaceBuilder().setName("cloud-ui-net-poc-01").createNetworkInterface())
                .withSubNetwork(new SubNetworkBuilder().setName("cloud-ui-subnet-poc-01").setIp_cidr_range("10.2.0.0/16")
                        .setNetwork("google_compute_network.cloud_ui_poc_network.id").setRegion("us-central1").createSubNetwork())
                .withFireWall(new FirewallBuilder().setName("cloud-ui-firewall-poc").setNetwork("google_compute_network.cloud_ui_poc_network.name")
                        .setProtocol1("icmp").setProtocol2("tcp").setPorts(ports).setSource_tags(tags).createFireWall())
                .withPersistentDisk(new PersistentDiskBuilder().setFamily("rhel-cloud").setProject("rhel-7").setName("cloud-ui-poc-vol")
                        .setSize("60").setType("pd-ssd").setImage("data.google_compute_image.t-compute-image.self_link").setZone("us-central1-a").createPersistentDisk())
                .withProvider(new ProviderBuilder().setProject("YOUR_PROJECT_ID").setRegion("us-central1").createProvider())
                .withMig(new MigBuilder().setName_prefix("my-template-").setMachine_type("n1-standard-1").setTags(mig_tags)
                        .setAutomatic_restart("true").setOn_host_maintenance("MIGRATE").setSubnetwork("google_compute_subnetwork.cloud_ui_poc_subnetwork.self_link")
                        .setSource("google_compute_disk.t-compute-disk.name").setAuto_delete("true").setBoot("true").setEmail("google_service_account.src_acc_poc.email")
                        .setScopes(mig_scopes).setCreate_before_destroy("true").setMig_name("substr(\"my-mig-${md5(google_compute_instance_template.template.name)}\", 0, 63)")
                        .setRegion("us-central1").setBase_instance_name("mig-instance").setTarget_size("1").setWait_for_instances("true").setDistribution_policy_zones(mig_distribution_policy_zones)
                        .setVersion_name("appserver").setInstance_template("google_compute_instance_template.template.self_link").setCreate_before_destroy("true")
                        .createMig())
                .withCloudDns(new CloudDnsBuilder().setManaged_name("cloudui").setManaged_dns_name("cloudui.com.")
                        .setManaged_zone("google_dns_managed_zone.example.name").setName("www.${google_dns_managed_zone.example.dns_name}")
                        .setType("A").setRrdatas(rrdatas).setTtl("300").createCloudDns())
                .withDBInstance(new DBInstanceBuilder().setDbinstancename("postgresmaster").setDbversion("POSTGRES_11")
                        .setTier("db-f1-micro").setDeletion_protection("true").setSqldbname("user").setSqldbinstance("google_sql_database_instance.db_instance.name")
                        .setPasswordlength("16").setPasswordspecial("true").setPasswordoverridespecial("_%@").setSqlusername("cloud_ui_user")
                        .setSqluserinstance("google_sql_database_instance.db_instance.name").setSqluserhost("*").setSqluserpassword("random_password.password.result")
                        .createDBInstance())
                .createComputeVM();
        writeToTempFile("main.tf",computeVM.toString());
    }*/

    //for 6 components
    public static String createMainTF1(ComputeVM compute, BootDisk bootDisk, PersistentDisk persistentDisk, ServiceAccount serviceAccount,
                                      Firewall firewall, NetworkInterface networkInterface, SubNetwork subNetwork) throws Exception {
        System.out.println("Generating main tf file");

        String[] scopes = {"\"cloud-platform\""};
        String vmname = compute.getName();//"Cloud-UI-POC";
        String vmzone = compute.getZone();//"us-central1-a";
        String vmmachinetype = compute.getMachine_type();//"n1-standard-1";
        String vmsource = compute.getSource();//"google_compute_disk.t-compute-disk.self_link";
        String vmnetworkint = compute.getNetworkInt();//"google_compute_network.cloud_ui_poc_network.self_link";
        String vmupdate = compute.getAllow_stopping_for_update();//"Yes";
        String vmemail = compute.getEmail();//"google_service_account.src_acc_poc.email";
        String bootDisksource = compute.getSource();//"google_compute_disk.t-compute-disk.self_link";
        String serviceaccountid = serviceAccount.getAccountID();//"cloud-ui-sa-poc";
        String serviceaccountdisplayname = serviceAccount.getDisplayName();//"POC Service Account";
        String networkinterfacename = networkInterface.getName();//"cloud-ui-net-poc-01";
        String subnetworkname = subNetwork.getName();//"cloud-ui-subnet-poc-01";
        String subnetworkrange = subNetwork.getIp_cidr_range();//"10.2.0.0/16";
        //String subnetworkid = subNetwork.getNetwork();//"google_compute_network.cloud_ui_poc_network.id";
        String subnetworkregion = subNetwork.getRegion();//"us-central1";
        String firewallname = firewall.getName();//"cloud-ui-firewall-poc";
        String firewallnetwork = firewall.getNetwork();//"google_compute_network.cloud_ui_poc_network.name";
        String firewallprotocol  = firewall.getProtocol();//"icmp";
        //String firewallprotocol2 = "tcp";
        String firewallports = firewall.getPorts();
        String firewalltags = firewall.getSource_tags();
        String persistentdiskfamily = persistentDisk.getFamily();//"rhel-cloud";
        String persistentdiskproject = persistentDisk.getProject();//"rhel-7";
        String persistentdiskname = persistentDisk.getName();//"cloud-ui-poc-vol";
        String persistentdisksize = persistentDisk.getSize();//"60";
        String persistentdisktype = persistentDisk.getType();//"pd-ssd";
        String persistentdiskimage = persistentDisk.getImage();//"data.google_compute_image.t-compute-image.self_link";
        String persistentdiskzone = persistentDisk.getZone();//"us-central1-a";
        final ComputeVM computeVM = new ComputeVMBuilder().setName(vmname).setZone(vmzone)
                .setMachine_type(vmmachinetype).setSource(vmsource)
                .setNetworkInt(vmnetworkint)
                .setAllow_stopping_for_update(vmupdate).setEmail(vmemail).setScopes(scopes)
                .withBootDisk(new BootDiskBuilder().setSource(bootDisksource).createBootDisk())
                .withServiceAccount(new ServiceAccountBuilder().setAccount_id(serviceaccountid).setDisplayName(serviceaccountdisplayname).createServiceAccount())
                .withNetworkInterface(new NetworkInterfaceBuilder().setName(networkinterfacename).createNetworkInterface())
                .withSubNetwork(new SubNetworkBuilder().setName(subnetworkname).setIp_cidr_range(subnetworkrange)
                        .setRegion(subnetworkregion).createSubNetwork())
                .withFireWall(new FirewallBuilder().setName(firewallname).setNetwork(firewallnetwork)
                        .setProtocol(firewallprotocol).setPorts(firewallports).setSource_tags(firewalltags).createFireWall())
                .withPersistentDisk(new PersistentDiskBuilder().setFamily(persistentdiskfamily).setProject(persistentdiskproject).
                        setName(persistentdiskname).setSize(persistentdisksize).setType(persistentdisktype)
                        .setImage(persistentdiskimage).setZone(persistentdiskzone).createPersistentDisk())
                .createComputeVM();

        //writting main.tf file
        //writeToTempFile("main1.tf",computeVM.toString());

        return computeVM.toString();
       // writeToTempFile("main.tf",computeVM.toString());
    }

    public static String createMainTF11(ComputeVM compute, BootDisk bootDisk, PersistentDisk persistentDisk, ServiceAccount serviceAccount,
                                       Firewall firewall, NetworkInterface networkInterface, SubNetwork subNetwork, Mig mig,
                                        CloudDns cloudDns, DBInstance dbInstance,LoadBalancing loadBalancing) throws Exception {
        System.out.println("Generating main tf file");

        String[] scopes = {"\"cloud-platform\""};
        String mig_scopes = "storage-rw";
        String mig_tags = "sample";
        String rrdatas = "8.8.8.8";
        System.out.println("check null");

        if(compute==null){
            System.out.println("compute is null");
        }
        final ComputeVM computeVM = new ComputeVMBuilder().setName(compute.getName()).setZone(compute.getZone())
                .setMachine_type(compute.getMachine_type()).setSource(compute.getSource())
                .setNetworkInt(compute.getNetworkInt())
                .setAllow_stopping_for_update(compute.getAllow_stopping_for_update()).setEmail(compute.getEmail()).setScopes(scopes)
                .withBootDisk(new BootDiskBuilder().setSource(compute.getSource()).createBootDisk())
                .withServiceAccount(new ServiceAccountBuilder().setAccount_id(serviceAccount.getAccountID()).setDisplayName(serviceAccount.getDisplayName()).createServiceAccount())
                .withNetworkInterface(new NetworkInterfaceBuilder().setName(networkInterface.getName()).createNetworkInterface())
                .withSubNetwork(new SubNetworkBuilder().setName(subNetwork.getName()).setIp_cidr_range(subNetwork.getIp_cidr_range())
                        .setRegion(subNetwork.getRegion()).createSubNetwork())
                .withFireWall(new FirewallBuilder().setName(firewall.getName()).setNetwork(firewall.getNetwork())
                        .setProtocol(firewall.getProtocol()).setPorts(firewall.getPorts()).setSource_tags(firewall.getSource_tags()).createFireWall())
                .withPersistentDisk(new PersistentDiskBuilder().setFamily(persistentDisk.getFamily()).setProject(persistentDisk.getProject()).
                        setName(persistentDisk.getName()).setSize(persistentDisk.getSize()).setType(persistentDisk.getType())
                        .setImage(persistentDisk.getImage()).setZone(persistentDisk.getZone()).createPersistentDisk())
                //4components
                .withMig(new MigBuilder().setName_prefix(mig.getName_prefix()).setMachine_type(mig.getMachine_type()).setTags(mig.getTags())
                        .setAutomatic_restart("true").setOn_host_maintenance("MIGRATE").setSubnetwork("google_compute_subnetwork.cloud_ui_poc_subnetwork.self_link")
                        .setSource("google_compute_disk.t-compute-disk.name").setAuto_delete("true").setBoot("true").setEmail("google_service_account.src_acc_poc.email")
                        .setScopes(mig_scopes).setCreate_before_destroy("true").setMig_name("substr(\"my-mig-${md5(google_compute_instance_template.template.name)}\", 0, 63)")
                        .setRegion("us-central1").setBase_instance_name("mig-instance").setTarget_size("1").setWait_for_instances("true")
                        //.setDistribution_policy_zones(mig_distribution_policy_zones)
                        .setVersion_name("appserver").setInstance_template("google_compute_instance_template.template.self_link")
                        .setCreate_before_destroy("true")
                        .createMig())
                .withCloudDns(new CloudDnsBuilder().setManaged_name(cloudDns.getManaged_name()).setManaged_dns_name(cloudDns.getManaged_dns_name())
                        .setManaged_zone("google_dns_managed_zone.example.name").setName("www.${google_dns_managed_zone.example.dns_name}")
                        .setType(cloudDns.getType()).setRrdatas(rrdatas).setTtl(cloudDns.getTtl()).createCloudDns())
                .withDBInstance(new DBInstanceBuilder().setDbinstancename(dbInstance.getDbinstancename()).setDbversion(dbInstance.getDbversion())
                        .setTier(dbInstance.getTier()).setDeletion_protection("false").setSqldbname("user").setSqldbinstance("google_sql_database_instance.db_instance.name")
                        .setPasswordlength("16").setPasswordspecial("true").setPasswordoverridespecial("_%@").setSqlusername("cloud_ui_user")
                        .setSqluserinstance("google_sql_database_instance.db_instance.name").setSqluserhost("*").setSqluserpassword("random_password.password.result")
                        .createDBInstance())
                .withLoadBalancing(new LoadBalancingBuilder().setRuleName(loadBalancing.getRuleName()).setRuleRegion(loadBalancing.getRuleRegion())
                        .setRuleportrange(loadBalancing.getRuleportrange()).setServicename(loadBalancing.getServicename()).setServiceregion(loadBalancing.getServiceregion())
                        .setServiceloadbalancingscheme(loadBalancing.getServiceloadbalancingscheme()).setHealthcheckname(loadBalancing.getHealthcheckname())
                        .setHealthcheckintervalsec(loadBalancing.getHealthcheckintervalsec()).setHealthchecktimeoutsec(loadBalancing.getHealthchecktimeoutsec())
                        .setHealthcheckregion(loadBalancing.getHealthcheckregion())
                        .createLoadBalancing())
                .createComputeVM();

        //writting main.tf file
        writeToTempFile(computeVM.toString());

        return computeVM.toString();
    }
}

