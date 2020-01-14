package com.ehabibov.driver.manager.browser;

import org.openqa.selenium.ie.InternetExplorerDriverLogLevel;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import java.io.File;
import java.io.IOException;

import com.ehabibov.driver.manager.DriverManager;
import com.ehabibov.driver.config.IeDriverConfig;
import com.ehabibov.driver.CapabilitiesPrinter;

public class IeDriverManager extends DriverManager {

    private InternetExplorerDriverService service;
    private IeDriverConfig config;
    private InternetExplorerOptions options;

    public void setIeDriverConfig(IeDriverConfig ieDriverConfig) {
        this.config = ieDriverConfig;
    }

    @Override
    protected void prepareService() {
        if (service == null) {
            driverBinaryConfig.init();
            service = new InternetExplorerDriverService.Builder()
                    .usingDriverExecutable(new File(driverBinaryConfig.getBinaryPath()))
                    .usingPort(0)

                    .withLogFile(file)
                    .withEnvironment(map)
                    .withSilent(true)
                    .withExtractPath(file)
                    .withHost("")
                    .withLogLevel(InternetExplorerDriverLogLevel.INFO);
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
        driver = new InternetExplorerDriver(service, options);
        new CapabilitiesPrinter(driver).printCapabilities();
    }

}