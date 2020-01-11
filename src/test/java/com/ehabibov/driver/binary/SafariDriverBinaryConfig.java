package com.ehabibov.driver.binary;

public class SafariDriverBinaryConfig implements DriverBinaryConfig {

    private String driverBinaryFolder;

    public SafariDriverBinaryConfig(String driverBinaryFolder) {
        this.driverBinaryFolder = driverBinaryFolder;
    }

    @Override
    public void init() {

    }

    public String getBinaryPath() {
        return driverBinaryFolder;
    }

}
