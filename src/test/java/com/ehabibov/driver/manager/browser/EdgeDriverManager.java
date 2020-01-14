package com.ehabibov.driver.manager.browser;

import org.openqa.selenium.edge.ChromiumEdgeDriverService;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.File;
import java.io.IOException;

import com.ehabibov.driver.manager.DriverManager;
import com.ehabibov.driver.config.EdgeDriverConfig;
import com.ehabibov.driver.CapabilitiesPrinter;

public class EdgeDriverManager extends DriverManager {

    private EdgeDriverService service;
    private EdgeDriverConfig config;
    private EdgeOptions options;

    public void setEdgeDriverConfig(EdgeDriverConfig edgeDriverConfig) {
        this.config = edgeDriverConfig;
    }

    @Override
    protected void prepareService() {
        if (service == null) {
            driverBinaryConfig.init();
            service = new ChromiumEdgeDriverService.Builder()
                    .usingDriverExecutable(new File(driverBinaryConfig.getBinaryPath()))
                    .usingPort(0)

                    .withEnvironment(map)
                    .withSilent(true)
                    .withVerbose(true);
                    .build();
        }
        options = config.getOptions();
    }

    @Override
    public void startService() {
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stopService() {
        if (service != null && service.isRunning())
            service.stop();
    }

    @Override
    public void createDriver() {
        driver = new RemoteWebDriver(service.getUrl(), options);
        new CapabilitiesPrinter(driver).printCapabilities();
    }

}