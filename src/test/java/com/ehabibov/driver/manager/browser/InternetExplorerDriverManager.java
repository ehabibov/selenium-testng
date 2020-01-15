package com.ehabibov.driver.manager.browser;

import org.openqa.selenium.ie.InternetExplorerDriverLogLevel;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.ehabibov.driver.config.InternetExplorerDriverConfig;
import com.ehabibov.driver.manager.DriverManager;
import com.ehabibov.driver.CapabilitiesPrinter;

public class InternetExplorerDriverManager extends DriverManager<InternetExplorerDriver> {

    private InternetExplorerDriverService service;
    private InternetExplorerDriverConfig config;
    private InternetExplorerOptions options;

    public void setInternetExplorerDriverConfig(InternetExplorerDriverConfig internetExplorerDriverConfig) {
        this.config = internetExplorerDriverConfig;
    }

    @Override
    protected void prepareService() {
        if (service == null) {
            driverBinaryConfig.init();
            service = new InternetExplorerDriverService.Builder()
                    .usingDriverExecutable(new File(driverBinaryConfig.getBinaryPath()))
                    .usingPort(0)

                    .withLogFile(new File("file"))
                    .withEnvironment(new HashMap<>())
                    .withSilent(true)
                    .withExtractPath(new File("file2"))
                    .withHost("")
                    .withLogLevel(InternetExplorerDriverLogLevel.TRACE)
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