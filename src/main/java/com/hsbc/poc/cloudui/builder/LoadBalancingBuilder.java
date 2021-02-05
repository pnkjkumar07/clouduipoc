package com.hsbc.poc.cloudui.builder;

import com.hsbc.poc.cloudui.model.LoadBalancing;

public class LoadBalancingBuilder {
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

    public LoadBalancingBuilder setRuleProvider(String ruleProvider) {
        this.ruleProvider = ruleProvider;
        return this;
    }

    public LoadBalancingBuilder setRuleName(String ruleName) {
        this.ruleName = ruleName;
        return this;
    }

    public LoadBalancingBuilder setRuleRegion(String ruleRegion) {
        this.ruleRegion = ruleRegion;
        return this;
    }

    public LoadBalancingBuilder setRuleportrange(String ruleportrange) {
        this.ruleportrange = ruleportrange;
        return this;
    }

    public LoadBalancingBuilder setRulebackendservice(String rulebackendservice) {
        this.rulebackendservice = rulebackendservice;
        return this;
    }

    public LoadBalancingBuilder setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
        return this;
    }

    public LoadBalancingBuilder setServicename(String servicename) {
        this.servicename = servicename;
        return this;
    }

    public LoadBalancingBuilder setServiceregion(String serviceregion) {
        this.serviceregion = serviceregion;
        return this;
    }

    public LoadBalancingBuilder setServiceloadbalancingscheme(String serviceloadbalancingscheme) {
        this.serviceloadbalancingscheme = serviceloadbalancingscheme;
        return this;
    }

    public LoadBalancingBuilder setServicehealthchecks(String servicehealthchecks) {
        this.servicehealthchecks = servicehealthchecks;
        return this;
    }

    public LoadBalancingBuilder setHealthcheckprovider(String healthcheckprovider) {
        this.healthcheckprovider = healthcheckprovider;
        return this;
    }

    public LoadBalancingBuilder setHealthcheckname(String healthcheckname) {
        this.healthcheckname = healthcheckname;
        return this;
    }

    public LoadBalancingBuilder setHealthcheckintervalsec(String healthcheckintervalsec) {
        this.healthcheckintervalsec = healthcheckintervalsec;
        return this;
    }

    public LoadBalancingBuilder setHealthchecktimeoutsec(String healthchecktimeoutsec) {
        this.healthchecktimeoutsec = healthchecktimeoutsec;
        return this;
    }

    public LoadBalancingBuilder setHealthcheckregion(String healthcheckregion) {
        this.healthcheckregion = healthcheckregion;
        return this;
    }

    public LoadBalancingBuilder setHealthchecktcpport(String healthchecktcpport) {
        this.healthchecktcpport = healthchecktcpport;
        return this;
    }

    public LoadBalancing createLoadBalancing() {
        return new LoadBalancing(ruleProvider, ruleName, ruleRegion, ruleportrange, rulebackendservice, serviceProvider, servicename, serviceregion, serviceloadbalancingscheme, servicehealthchecks, healthcheckprovider, healthcheckname, healthcheckintervalsec, healthchecktimeoutsec, healthcheckregion, healthchecktcpport);
    }
}