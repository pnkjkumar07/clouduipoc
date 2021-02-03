package com.hsbc.poc.cloudui.model;

import java.io.Serializable;

public class BootDisk implements Serializable {

    private static final long serialVersionUID = -299482035708790409L;
    private String source;

    public BootDisk(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "\r\n boot_disk {" +
                "\r\n source=" + source +
                "\r\n }";
    }
}
