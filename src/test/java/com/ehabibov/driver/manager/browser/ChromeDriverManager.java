package com.ehabibov.driver.manager.browser;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.io.IOException;

import com.ehabibov.driver.manager.DriverManager;
import com.ehabibov.driver.config.ChromeDriverConfig;

public class ChromeDriverManager extends DriverManager {

    private ChromeDriverService chromeDriverService;
    private ChromeDriverConfig chromeDriverConfig;

    public void setChromeDriverConfig(ChromeDriverConfig chromeDriverConfig) {
        this.chromeDriverConfig = chromeDriverConfig;
    }

    @Override
    protected void prepareService() {
        if (chromeDriverService == null) {
            driverBinaryConfig.init();
            chromeDriverService = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(driverBinaryConfig.getBinaryPath()))
                    .usingAnyFreePort()
                    .build();
        }
    }

    @Override
    public void startService() {
        try {
            chromeDriverService.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stopService() {
        if (chromeDriverService != null && chromeDriverService.isRunning())
            chromeDriverService.stop();
    }

    @Override
    public void createDriver() {
        ChromeOptions options = new ChromeOptions();
        /*
        options.addArguments();
        options.addExtensions();
        options.addEncodedExtensions();
        options.setAcceptInsecureCerts();
        options.setBinary();
        options.setCapability();
        options.setExperimentalOption();
        options.setHeadless();
        options.setPageLoadStrategy();
        options.setProxy();
        options.setStrictFileInteractability();
        options.setUnhandledPromptBehaviour();
        */
        driver = new ChromeDriver(chromeDriverService, options);
    }

}