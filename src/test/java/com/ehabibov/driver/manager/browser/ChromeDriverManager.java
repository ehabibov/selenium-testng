package com.ehabibov.driver.manager.browser;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.ehabibov.driver.CapabilitiesPrinter;
import com.ehabibov.driver.manager.DriverManager;
import com.ehabibov.driver.config.browser.ChromeDriverConfig;

public class ChromeDriverManager extends DriverManager<ChromeDriver> {

    private ChromeDriverService service;
    private ChromeDriverConfig config;
    private ChromeOptions options;

    public void setChromeDriverConfig(ChromeDriverConfig chromeDriverConfig) {
        this.config = chromeDriverConfig;
    }

    @Override
    protected void prepareService() {
        if (service == null) {
            driverBinaryConfig.init();
            service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(driverBinaryConfig.getBinaryPath()))
                    .usingPort(0)

                    .withEnvironment(new HashMap<>())
                    .withLogFile(new File("file"))
                    //.withSilent(true)
                    .withAppendLog(true)
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
        if (service != null && service.isRunning())
            service.stop();
    }

    @Override
    public void createDriver() {
        driver = new ChromeDriver(service, options);
        new CapabilitiesPrinter(driver).printCapabilities();
    }

}