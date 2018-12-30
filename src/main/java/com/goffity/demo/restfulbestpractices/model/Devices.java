package com.goffity.demo.restfulbestpractices.model;

import org.springframework.hateoas.ResourceSupport;

public class Devices extends ResourceSupport {
    private int deviceId;
    private String name;
    private int type;

    public Devices(int deviceId, String name, int type) {
        this.deviceId = deviceId;
        this.name = name;
        this.type = type;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
