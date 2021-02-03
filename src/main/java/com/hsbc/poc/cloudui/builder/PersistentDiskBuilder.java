package com.hsbc.poc.cloudui.builder;

import com.hsbc.poc.cloudui.model.PersistentDisk;

public class PersistentDiskBuilder {

    private String family;
    private String project;
    private String name;
    private String size;
    private String type;
    private String image;
    private String zone;

    public PersistentDiskBuilder setFamily(String family) {
        this.family = family;
        return this;
    }

    public PersistentDiskBuilder setProject(String project) {
        this.project = project;
        return this;
    }

    public PersistentDiskBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersistentDiskBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    public PersistentDiskBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public PersistentDiskBuilder setImage(String image) {
        this.image = image;
        return this;
    }

    public PersistentDiskBuilder setZone(String zone) {
        this.zone = zone;
        return this;
    }

    public PersistentDisk createPersistentDisk(){
        return new PersistentDisk(family, project, name, size, type, image, zone);
    }
}
