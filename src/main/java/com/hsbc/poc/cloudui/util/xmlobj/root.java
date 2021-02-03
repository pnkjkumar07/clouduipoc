package com.hsbc.poc.cloudui.util.xmlobj;

import java.util.List;

public class Root {

    List<MxCell> MxCell;
    List<Object> Object;
    public List<MxCell> getMxCell() {
        return this.MxCell;
    }
    public void setMxCell(List<MxCell> MxCell) {
        this.MxCell = MxCell;
    }

    public List<Object> getObject() {
        return this.Object;
    }
    public void setObject(List<Object> Object) {
        this.Object = Object;
    }

}
