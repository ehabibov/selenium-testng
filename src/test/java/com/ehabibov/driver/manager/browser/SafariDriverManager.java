package com.ehabibov.driver.manager.browser;

import org.openqa.selenium.safari.SafariDriverService;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.ehabibov.driver.manager.DriverManager;
import com.ehabibov.driver.config.SafariDriverConfig;
import com.ehabibov.driver.CapabilitiesPrinter;

public class SafariDriverManager extends DriverManager<SafariDriver> {

    private SafariDriverService service;
    private SafariDriverConfig config;
    private SafariOptions options;

    public void setSafariDriverConfig(SafariDriverConfig safariDriverConfig) {
        this.config = safariDriverConfig;
    }

    @Override
    public void prepareService() {
        driverBinaryConfig.init();
        if (service == null) {
            service = new SafariDriverService.Builder()
                    .usingDriverExecutable(new File(driverBinaryConfig.getBinaryPath()))
                    .usingPort(0)

                    .withLogFile(new File("file"))
                    .withEnvironment(new HashMap<>())
                    .usingTechnologyPreview(true)
                    .build();
        }
        options = config.getOptions();
    }

    @Override
    public void startService(){
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stopService() {
        if (service != null  && service.isRunning())
            service.stop();
    }

    @Override
    public void createDriver() {
        driver = new SafariDriver(service, options);
        new CapabilitiesPrinter(driver).printCapabilities();
    }
}
