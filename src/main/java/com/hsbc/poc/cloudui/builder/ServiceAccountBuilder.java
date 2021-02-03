package com.hsbc.poc.cloudui.builder;

import com.hsbc.poc.cloudui.model.ServiceAccount;

public class ServiceAccountBuilder {

    private String account_id;
    private String displayName;

    public ServiceAccountBuilder setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public ServiceAccountBuilder setAccount_id(String account_id) {
        this.account_id = account_id;
        return this;
    }

    public ServiceAccount createServiceAccount(){
        return new ServiceAccount(account_id, displayName);
    }
}
