package com.ehabibov.driver.manager.browser;

import org.openqa.selenium.edge.ChromiumEdgeDriverService;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.ehabibov.driver.manager.CommonDriverManagerLifecycle;
import com.ehabibov.driver.config.browser.EdgeDriverConfig;
import com.ehabibov.driver.CapabilitiesPrinter;

public class EdgeDriverManager extends CommonDriverManagerLifecycle {

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
                    .withLogFile(new File("file"))
                    .withEnvironment(new HashMap<>())
                    .withAllowedListIps("")
                    //.withSilent(true)
                    //.withVerbose(true)
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
        //TODO: pass service into constructor with type safety
        driver = new EdgeDriver(options);
        new CapabilitiesPrinter(driver).printCapabilities();
    }
}