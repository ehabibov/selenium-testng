package com.ehabibov.driver.manager.browser;

import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import java.io.File;
import java.io.IOException;

import com.ehabibov.driver.manager.DriverManager;
import com.ehabibov.driver.config.OperaDriverConfig;
import com.ehabibov.driver.CapabilitiesPrinter;

public class OperaDriverManager extends DriverManager {

    private OperaDriverService service;
    private OperaDriverConfig config;
    private OperaOptions options;

    public void setOperaDriverConfig(OperaDriverConfig operaDriverConfig) {
        this.config = operaDriverConfig;
    }

    @Override
    protected void prepareService() {
        if (service == null) {
            driverBinaryConfig.init();
            service = new OperaDriverService.Builder()
                    .usingDriverExecutable(new File(driverBinaryConfig.getBinaryPath()))
                    .usingPort(0)

                    .withLogFile(file)
                    .withEnvironment(map)
                    .withSilent(true)
                    .withVerbose(true)
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
        if (service !=null && service.isRunning())
            service.stop();
    }

    @Override
    public void createDriver() {
        driver = new OperaDriver(service, options);
        new CapabilitiesPrinter(driver).printCapabilities();
    }

}