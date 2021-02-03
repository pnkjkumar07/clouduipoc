package com.hsbc.poc.cloudui.util.xmlobj;

public class Diagram {

    String Name;
    MxGraphModel MxGraphModel;
    String Id;

    public MxGraphModel getMxGraphModel() {
        return this.MxGraphModel;
    }
    public void setMxGraphModel(MxGraphModel MxGraphModel) {
        this.MxGraphModel = MxGraphModel;
    }

    public String getId() {
        return this.Id;
    }
    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return this.Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
}
