package com.hsbc.poc.cloudui.model;

import java.io.Serializable;
import java.util.Arrays;

public class Firewall implements Serializable {

    private static final long serialVersionUID = -299482035708790405L;
    private String name;
    private String network;
    private String source_tags;
    private String protocol;
   // private String protocol2;
    private String ports;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getPorts() {
        return ports;
    }

    public void setPorts(String ports) {
        this.ports = ports;
    }

    public String getSource_tags() {
        return source_tags;
    }

    public void setSource_tags(String source_tags) {
        this.source_tags = source_tags;
    }

    public Firewall(String name, String network, String source_tags, String protocol, String ports) {
        this.name = name;
        this.network = network;
        this.source_tags = source_tags;
        this.protocol = protocol;
        //this.protocol2 = protocol2;
        this.ports = ports;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    @Override
    public String toString() {
        //String source = Arrays.toString(source_tags);
        //String port = Arrays.toString(ports);
        /*if(null != port){
            port.replace("[", "").replace("]", "");
        }
        if(null != source) {
            //source = source.replace("[", "\"").replace("]", "\"");
        }*/
        return " \r\n ## Create a Firewall" +
                "\r\n resource \"google_compute_firewall\" \"default\" {" +
                "\r\n name = \"" + name +"\"" +
                "\r\n network = google_compute_network.cloud_ui_poc_network.name" +
                "\r\n source_tags = [\"" + source_tags +"\"]" +
                "\r\n allow { \r\n protocol =  \""  + protocol +"\" \r\n }" +
                "\r\n allow { \r\n protocol =  \""  + "tcp" +"\" \r\n  ports = ["+ "\"80\", \"8080\", \"1000-2000\"" + "]\r\n }" +
                "\r\n }";
    }
}
