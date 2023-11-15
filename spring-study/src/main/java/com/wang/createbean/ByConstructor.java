package com.wang.createbean;

public class ByConstructor {
    
    private String attribute;

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public ByConstructor() {
    }

    public ByConstructor(String attribute) {
        this.attribute = attribute;
    }
}
