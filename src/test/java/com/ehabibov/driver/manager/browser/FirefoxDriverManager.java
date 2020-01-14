package com.ehabibov.driver.manager.browser;

import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.File;
import java.io.IOException;

import com.ehabibov.driver.manager.DriverManager;
import com.ehabibov.driver.config.FirefoxDriverConfig;
import com.ehabibov.driver.CapabilitiesPrinter;

public class FirefoxDriverManager extends DriverManager {

    private FirefoxDriverService service;
    private FirefoxDriverConfig config;
    private FirefoxOptions options;

    public void setFirefoxDriverConfig(FirefoxDriverConfig firefoxDriverConfig) {
        this.config = firefoxDriverConfig;
    }

    @Override
    protected void prepareService() {
        if (service == null) {
            driverBinaryConfig.init();
            service = new GeckoDriverService.Builder()
                    .usingDriverExecutable(new File(driverBinaryConfig.getBinaryPath()))
                    .usingPort(0)

                    .withLogFile(file)
                    .withEnvironment(map)
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
        driver = new FirefoxDriver(service, options);
        new CapabilitiesPrinter(driver).printCapabilities();
    }

}