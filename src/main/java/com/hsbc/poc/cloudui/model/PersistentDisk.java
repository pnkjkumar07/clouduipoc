package com.hsbc.poc.cloudui.model;

import java.io.Serializable;

public class PersistentDisk implements Serializable {

    private static final long serialVersionUID = -299482035708790402L;
    private String family;
    private String project;
    private String name;
    private String size;
    private String type;
    private String image;
    private String zone;

    public PersistentDisk(String family, String project, String name, String size, String type, String image, String zone) {
        this.family = family;
        this.project = project;
        this.name = name;
        this.size = size;
        this.type = type;
        this.image = image;
        this.zone = zone;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        return "\r\n ## Create a persistent disk" +
                "\r\n data \"google_compute_image\" \"t-compute-image\" {" +
                "\r\n family = \"" + family + "\"" +
                "\r\n project = \"" + project + "\" \r\n }" +
                "\r\n resource \"google_compute_disk\" \"t-compute-disk\" { \r\n name= \"" + name + "\"" +
                "\r\n size = " + size +
                "\r\n type = \"" + type + "\"" +
                "\r\n image = data.google_compute_image.t-compute-image.self_link" +
                "\r\n zone = \"" + zone + "\"" +
                "\r\n }";
    }
}
