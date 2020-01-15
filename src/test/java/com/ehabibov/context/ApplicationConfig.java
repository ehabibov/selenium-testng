package com.ehabibov.context;

public class ApplicationConfig {

    private String applicationHost;
    private int applicationPort;
    private String browserType;

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
}
