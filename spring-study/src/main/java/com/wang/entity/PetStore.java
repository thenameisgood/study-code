package com.wang.entity;

public class PetStore {
    public String username;
    public String type;
    public String location;

    public PetStore() {
    }

    public PetStore(String username, String type, String location) {
        this.username = username;
        this.type = type;
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
