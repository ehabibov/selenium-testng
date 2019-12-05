package com.ehabibov.driver.config;

import java.util.List;

public class OperaDriverConfig {

    private String port;
    private List<String> startArguments;

    public OperaDriverConfig(String port, List<String> startArguments) {
        this.port = port;
        this.startArguments = startArguments;
    }

    public String getPort() {
        return port;
    }

    public List<String> getStartArguments() {
        return startArguments;
    }
}
