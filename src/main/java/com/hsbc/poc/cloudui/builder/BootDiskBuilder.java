package com.hsbc.poc.cloudui.builder;


import com.hsbc.poc.cloudui.model.BootDisk;

public class BootDiskBuilder {

    private String source;

    public BootDiskBuilder setSource(String source) {
        this.source = source;
        return this;
    }

    public BootDisk createBootDisk(){
        return new BootDisk(source);
    }
}
