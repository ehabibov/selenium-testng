package com.ehabibov.driver.binary;

public class SafariDriverBinaryConfig implements DriverBinaryConfig {

    private String driverBinaryFolder;

    public SafariDriverBinaryConfig(String driverBinaryFolder) {
        this.driverBinaryFolder = driverBinaryFolder;
    }

    //TODO: segregate interface
    @Override
    public void init() {

    }

    public String getBinaryPath() {
        return driverBinaryFolder;
    }
}