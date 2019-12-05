package com.ehabibov.driver.manager;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.io.IOException;

import com.ehabibov.driver.binary.ChromeBinaryConfig;
import com.ehabibov.driver.config.ChromeDriverConfig;

public class ChromeDriverManager extends DriverManager {

    private ChromeDriverService chromeDriverService;
    private ChromeBinaryConfig chromeBinaryConfig;
    private ChromeDriverConfig chromeDriverConfig;

    public void setChromeBinaryConfig(ChromeBinaryConfig chromeBinaryConfig) {
        this.chromeBinaryConfig = chromeBinaryConfig;
    }

    public void setChromeDriverConfig(ChromeDriverConfig chromeDriverConfig) {
        this.chromeDriverConfig = chromeDriverConfig;
    }

    @Override
    protected void prepareService() {
        if (null == chromeDriverService) {
            chromeBinaryConfig.construct();
            chromeBinaryConfig.init();
            File binary = new File(chromeBinaryConfig.getBinaryPath());
            chromeDriverService = new ChromeDriverService.Builder()
                    .usingDriverExecutable(binary)
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