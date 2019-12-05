package com.ehabibov.driver.binary;

public class SafariBinaryConfig {

    private String driverBinaryFolder;

    public SafariBinaryConfig(String driverBinaryFolder) {
        this.driverBinaryFolder = driverBinaryFolder;
    }

    public String getBinaryPath() {
        return driverBinaryFolder;
    }
}
