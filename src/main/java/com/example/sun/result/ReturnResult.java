package com.example.sun.result;

import sun.swing.SwingUtilities2;

public abstract class ReturnResult {
    String staus;
    String stausEmessage;
    Object data;


    public String getStaus() {
        return staus;
    }

    public void setStaus(String staus) {
        this.staus = staus;
    }

    public String getStausEmessage() {
        return stausEmessage;
    }

    public void setStausEmessage(String stausEmessage) {
        this.stausEmessage = stausEmessage;
    }

    public Object getObject() {
        return data;
    }

    public void setObject(Object object) {
        this.data = object;
    }
}
