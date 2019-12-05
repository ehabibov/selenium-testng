package com.ehabibov.driver.manager;

import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.File;
import java.io.IOException;

import com.ehabibov.driver.binary.FirefoxBinaryConfig;
import com.ehabibov.driver.config.FirefoxDriverConfig;

public class FirefoxDriverManager extends DriverManager {

    private FirefoxDriverService firefoxDriverService;
    private FirefoxBinaryConfig firefoxBinaryConfig;
    private FirefoxDriverConfig firefoxDriverConfig;

    public void setFirefoxBinaryConfig(FirefoxBinaryConfig firefoxBinaryConfig) {
        this.firefoxBinaryConfig = firefoxBinaryConfig;
    }

    public void setFirefoxDriverConfig(FirefoxDriverConfig firefoxDriverConfig) {
        this.firefoxDriverConfig = firefoxDriverConfig;
    }

    @Override
    protected void prepareService() {
        if (firefoxDriverService == null) {
            firefoxBinaryConfig.construct();
            firefoxBinaryConfig.init();
            firefoxDriverService = new GeckoDriverService.Builder()
                    .usingDriverExecutable(new File(firefoxBinaryConfig.getBinaryPath()))
                    .usingAnyFreePort()
                    .build();
        }
    }

    @Override
    public void startService() {
        try {
            firefoxDriverService.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stopService() {
        if (firefoxDriverService != null && firefoxDriverService.isRunning())
            firefoxDriverService.stop();
    }

    @Override
    public void createDriver() {
        FirefoxOptions options = new FirefoxOptions();
        /*
        options.addArguments();
        options.addPreference();
        options.setBinary();
        options.setCapability();
        options.setHeadless();
        options.setLegacy();
        options.setLogLevel()
        options.setPageLoadStrategy();
        options.setProfile();
        options.setProxy();
        options.setStrictFileInteractability();
        options.setUnhandledPromptBehaviour();
        options.asMap();
        */
        driver = new FirefoxDriver(firefoxDriverService, options);
    }

}