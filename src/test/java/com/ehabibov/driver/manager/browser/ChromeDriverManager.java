package com.ehabibov.driver.manager.browser;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Capabilities;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.ehabibov.driver.manager.CommonDriverManagerLifecycle;
import com.ehabibov.driver.config.OptionsFetcher;
import com.ehabibov.driver.config.browser.ChromeOptionsHolder;
import com.ehabibov.driver.CapabilitiesPrinter;

public class ChromeDriverManager extends CommonDriverManagerLifecycle {

    private OptionsFetcher optionsFetcher = new OptionsFetcher(ChromeOptionsHolder.class);
    private ChromeDriverService service;
    private Capabilities capabilities;

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
        capabilities = optionsFetcher.getOptions();
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
        driver = new ChromeDriver(service, capabilities);
        new CapabilitiesPrinter(driver).printCapabilities();
    }
}