package com.hsbc.poc.cloudui.model;

public class LoadBalancing {

    private String ruleProvider;
    private String ruleName;
    private String ruleRegion;
    private String ruleportrange;
    private String rulebackendservice;
    private String serviceProvider;
    private String servicename;
    private String serviceregion;
    private String serviceloadbalancingscheme;
    private String servicehealthchecks;
    private String healthcheckprovider;
    private String healthcheckname;
    private String healthcheckintervalsec;
    private String healthchecktimeoutsec;
    private String healthcheckregion;
    private String healthchecktcpport;

    public LoadBalancing(String ruleProvider, String ruleName, String ruleRegion, String ruleportrange, String rulebackendservice, String serviceProvider, String servicename, String serviceregion, String serviceloadbalancingscheme, String servicehealthchecks, String healthcheckprovider, String healthcheckname, String healthcheckintervalsec, String healthchecktimeoutsec, String healthcheckregion, String healthchecktcpport) {
        this.ruleProvider = ruleProvider;
        this.ruleName = ruleName;
        this.ruleRegion = ruleRegion;
        this.ruleportrange = ruleportrange;
        this.rulebackendservice = rulebackendservice;
        this.serviceProvider = serviceProvider;
        this.servicename = servicename;
        this.serviceregion = serviceregion;
        this.serviceloadbalancingscheme = serviceloadbalancingscheme;
        this.servicehealthchecks = servicehealthchecks;
        this.healthcheckprovider = healthcheckprovider;
        this.healthcheckname = healthcheckname;
        this.healthcheckintervalsec = healthcheckintervalsec;
        this.healthchecktimeoutsec = healthchecktimeoutsec;
        this.healthcheckregion = healthcheckregion;
        this.healthchecktcpport = healthchecktcpport;
    }

    public LoadBalancing(String ruleName, String ruleRegion, String ruleportrange, String rulebackendservice, String servicename,
            String serviceregion, String serviceloadbalancingscheme, String servicehealthchecks, String healthcheckname,
            String healthcheckintervalsec, String healthchecktimeoutsec, String healthcheckregion){
            this.ruleName = ruleName;
            this.ruleRegion = ruleRegion;
            this.ruleportrange = ruleportrange;
            this.rulebackendservice = rulebackendservice;
            this.servicename = servicename;
            this.serviceregion = serviceregion;
            this.serviceloadbalancingscheme = serviceloadbalancingscheme;
            this.servicehealthchecks = servicehealthchecks;
            this.healthcheckname = healthcheckname;
            this.healthcheckintervalsec = healthcheckintervalsec;
            this.healthchecktimeoutsec = healthchecktimeoutsec;
            this.healthcheckregion = healthcheckregion;
    }

    @Override
    public String toString() {
        return "\r\n ## Forwarding rule for External Network Load Balancing using Backend Services" +
                "\r\n resource \"google_compute_forwarding_rule\" \"t-google-compute-forwarding-rule\" {" +
                //"\r\n provider = google-beta" +
                "\r\n name = \""+ruleName+"\"" +
                "\r\n region = \""+ruleRegion+"\"" +
                "\r\n port_range = "+ruleportrange +
                "\r\n backend_service = google_compute_region_backend_service.t-google-compute-region-backend-service.id \r\n }" +
                "\r\n resource \"google_compute_region_backend_service\" \"t-google-compute-region-backend-service\" {" +
               // "\r\n provider = google-beta"  +
                "\r\n name = \""+servicename+"\"" +
                "\r\n region = \""+serviceregion+"\"" +
                "\r\n load_balancing_scheme = \""+serviceloadbalancingscheme+"\"" +
                "\r\n health_checks = [google_compute_region_health_check.t-google-compute-region-health-check.id] \r\n }" +
                "\r\n resource \"google_compute_region_health_check\" \"t-google-compute-region-health-check\" {" +
                //"\r\n provider = google-beta" +
                "\r\n name = \""+healthcheckname+"\"" +
                "\r\n check_interval_sec = "+healthcheckintervalsec +
                "\r\n timeout_sec = " +healthchecktimeoutsec +
                "\r\n region = \""+healthcheckregion+"\"" +
                "\r\n tcp_health_check {" +
                "\r\n port = \"80\" \r\n }" +
                "\r\n }";

    }

    public String getRuleProvider() {
        return ruleProvider;
    }

    public void setRuleProvider(String ruleProvider) {
        this.ruleProvider = ruleProvider;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleRegion() {
        return ruleRegion;
    }

    public void setRuleRegion(String ruleRegion) {
        this.ruleRegion = ruleRegion;
    }

    public String getRuleportrange() {
        return ruleportrange;
    }

    public void setRuleportrange(String ruleportrange) {
        this.ruleportrange = ruleportrange;
    }

    public String getRulebackendservice() {
        return rulebackendservice;
    }

    public void setRulebackendservice(String rulebackendservice) {
        this.rulebackendservice = rulebackendservice;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getServiceregion() {
        return serviceregion;
    }

    public void setServiceregion(String serviceregion) {
        this.serviceregion = serviceregion;
    }

    public String getServiceloadbalancingscheme() {
        return serviceloadbalancingscheme;
    }

    public void setServiceloadbalancingscheme(String serviceloadbalancingscheme) {
        this.serviceloadbalancingscheme = serviceloadbalancingscheme;
    }

    public String getServicehealthchecks() {
        return servicehealthchecks;
    }

    public void setServicehealthchecks(String servicehealthchecks) {
        this.servicehealthchecks = servicehealthchecks;
    }

    public String getHealthcheckprovider() {
        return healthcheckprovider;
    }

    public void setHealthcheckprovider(String healthcheckprovider) {
        this.healthcheckprovider = healthcheckprovider;
    }

    public String getHealthcheckname() {
        return healthcheckname;
    }

    public void setHealthcheckname(String healthcheckname) {
        this.healthcheckname = healthcheckname;
    }

    public String getHealthcheckintervalsec() {
        return healthcheckintervalsec;
    }

    public void setHealthcheckintervalsec(String healthcheckintervalsec) {
        this.healthcheckintervalsec = healthcheckintervalsec;
    }

    public String getHealthchecktimeoutsec() {
        return healthchecktimeoutsec;
    }

    public void setHealthchecktimeoutsec(String healthchecktimeoutsec) {
        this.healthchecktimeoutsec = healthchecktimeoutsec;
    }

    public String getHealthcheckregion() {
        return healthcheckregion;
    }

    public void setHealthcheckregion(String healthcheckregion) {
        this.healthcheckregion = healthcheckregion;
    }

    public String getHealthchecktcpport() {
        return healthchecktcpport;
    }

    public void setHealthchecktcpport(String healthchecktcpport) {
        this.healthchecktcpport = healthchecktcpport;
    }
}
