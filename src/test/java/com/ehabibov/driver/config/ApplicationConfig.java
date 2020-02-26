package com.ehabibov.driver.config;

import lombok.Data;

@Data
public class ApplicationConfig {

    private String applicationHost;
    private int applicationPort;
    private String browserType;
    private boolean remoteDriver;
    private String remoteDriverUrl;

}