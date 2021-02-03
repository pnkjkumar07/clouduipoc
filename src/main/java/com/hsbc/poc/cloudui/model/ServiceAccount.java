package com.hsbc.poc.cloudui.model;

import java.io.Serializable;

public class ServiceAccount implements Serializable {

    private static final long serialVersionUID = -299482035708790400L;
    private String accountID;
    private String displayName;

    public ServiceAccount(String accountID, String displayName) {
        this.accountID = accountID;
        this.displayName = displayName;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return "## Create a Service Network" +
                "\r\n resource \"google_service_account\" \"src_acc_poc\" {" +
                "\r\n account_id=\"" + accountID +"\"" +
                "\r\n display_name=\"" + displayName +"\"" +
                "\r\n }";
    }
}
