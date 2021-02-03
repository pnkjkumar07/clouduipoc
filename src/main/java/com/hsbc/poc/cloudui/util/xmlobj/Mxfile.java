package com.hsbc.poc.cloudui.util.xmlobj;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

//@XmlRootElement
public class Mxfile {

    Diagram Diagram;
    String Host;
    Date Modified;
    String Agent;
    String Etag;
    String Version;

    public Diagram getDiagram() {
        return this.Diagram;
    }
    public void setDiagram(Diagram Diagram) {
        this.Diagram = Diagram;
    }

    public String getHost() {
        return this.Host;
    }
    public void setHost(String Host) {
        this.Host = Host;
    }

    public Date getModified() {
        return this.Modified;
    }
    public void setModified(Date Modified) {
        this.Modified = Modified;
    }

    public String getAgent() {
        return this.Agent;
    }
    public void setAgent(String Agent) {
        this.Agent = Agent;
    }

    public String getEtag() {
        return this.Etag;
    }
    public void setEtag(String Etag) {
        this.Etag = Etag;
    }

    public String getVersion() {
        return this.Version;
    }
    public void setVersion(String Version) {
        this.Version = Version;
    }

}

