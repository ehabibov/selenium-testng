package com.ehabibov.driver.config;

public class ApplicationConfig {

    private String applicationHost;
    private int applicationPort;
    private String browserType;
    private boolean remoteDriver;
    private String remoteDriverUrl;

    public String getApplicationHost() {
        return applicationHost;
    }

    public void setApplicationHost(String applicationHost) {
        this.applicationHost = applicationHost;
    }

    public int getApplicationPort() {
        return applicationPort;
    }

    public void setApplicationPort(int applicationPort) {
        this.applicationPort = applicationPort;
    }

    public String getBrowserType() {
        return browserType;
    }

    public void setBrowserType(String browserType) {
        this.browserType = browserType;
    }

    public boolean isRemoteDriver() {
        return remoteDriver;
    }

    public void setRemoteDriver(boolean remoteDriver) {
        this.remoteDriver = remoteDriver;
    }

    public String getRemoteDriverUrl() {
        return remoteDriverUrl;
    }

    public void setRemoteDriverUrl(String remoteDriverUrl) {
        this.remoteDriverUrl = remoteDriverUrl;
    }
}
