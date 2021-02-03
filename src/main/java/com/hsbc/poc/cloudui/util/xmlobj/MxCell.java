package com.hsbc.poc.cloudui.util.xmlobj;

public class MxCell {
    int Id;
    int Parent;
    MxGeometry MxGeometry;
    String Value;
    String Style;
    int Vertex;
    int Edge;
    String Source;
    String Target;
    public int getId() {
        return this.Id;
    }
    public void setId(int Id) {
        this.Id = Id;
    }

    public int getParent() {
        return this.Parent;
    }
    public void setParent(int Parent) {
        this.Parent = Parent;
    }

    public MxGeometry getMxGeometry() {
        return this.MxGeometry;
    }
    public void setMxGeometry(MxGeometry MxGeometry) {
        this.MxGeometry = MxGeometry;
    }

    public String getValue() {
        return this.Value;
    }
    public void setValue(String Value) {
        this.Value = Value;
    }

    public String getStyle() {
        return this.Style;
    }
    public void setStyle(String Style) {
        this.Style = Style;
    }

    public int getVertex() {
        return this.Vertex;
    }
    public void setVertex(int Vertex) {
        this.Vertex = Vertex;
    }

    public int getEdge() {
        return this.Edge;
    }
    public void setEdge(int Edge) {
        this.Edge = Edge;
    }

    public String getSource() {
        return this.Source;
    }
    public void setSource(String Source) {
        this.Source = Source;
    }

    public String getTarget() {
        return this.Target;
    }
    public void setTarget(String Target) {
        this.Target = Target;
    }

}


