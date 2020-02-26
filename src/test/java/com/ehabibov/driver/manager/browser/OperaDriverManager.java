package com.ehabibov.driver.manager.browser;

import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.ehabibov.driver.manager.CommonDriverManagerLifecycle;
import com.ehabibov.driver.config.browser.OperaDriverConfig;
import com.ehabibov.driver.CapabilitiesPrinter;

public class OperaDriverManager extends CommonDriverManagerLifecycle {

    private OperaDriverService service;
    private OperaDriverConfig config;
    private OperaOptions options;

    public void setOperaDriverConfig(final OperaDriverConfig operaDriverConfig) {
        this.config = operaDriverConfig;
    }

    @Override
    protected void prepareService() {
        if (service == null) {
            driverBinaryConfig.init();
            service = new OperaDriverService.Builder()
                    .usingDriverExecutable(new File(driverBinaryConfig.getBinaryPath()))
                    .usingPort(0)

                    .withLogFile(new File("file"))
                    .withEnvironment(new HashMap<>())
                    //.withSilent(true)
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
        if (service != null && service.isRunning()) {
            service.stop();
        }
    }

    @Override
    public void createDriver() {
        driver = new OperaDriver(service, options);
        new CapabilitiesPrinter(driver).printCapabilities();
    }
}