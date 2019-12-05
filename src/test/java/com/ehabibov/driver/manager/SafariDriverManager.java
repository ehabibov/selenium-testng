package com.ehabibov.driver.manager;

import org.openqa.selenium.safari.SafariDriverService;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import java.io.File;
import java.io.IOException;

import com.ehabibov.driver.binary.SafariBinaryConfig;
import com.ehabibov.driver.config.SafariDriverConfig;

public class SafariDriverManager extends DriverManager {

    private SafariDriverService safariDriverService;
    private SafariBinaryConfig safariBinaryConfig;
    private SafariDriverConfig safariDriverConfig;

    public void setSafariBinaryConfig(SafariBinaryConfig safariBinaryConfig) {
        this.safariBinaryConfig = safariBinaryConfig;
    }

    public void setSafariDriverConfig(SafariDriverConfig safariDriverConfig) {
        this.safariDriverConfig = safariDriverConfig;
    }

    @Override
    public void prepareService() {
        if (safariDriverService == null) {
            safariDriverService = new SafariDriverService.Builder()
                    .usingDriverExecutable(new File(safariBinaryConfig.getBinaryPath()))
                    .usingAnyFreePort()
                    .build();
        }
    }

    @Override
    public void startService(){
        try {
            safariDriverService.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stopService() {
        if (safariDriverService != null  && safariDriverService.isRunning())
            safariDriverService.stop();
    }

    @Override
    public void createDriver() {
        SafariOptions options = new SafariOptions();
        /*
        options.setAcceptInsecureCerts();
        options.setAutomaticInspection();
        options.setAutomaticProfiling();
        options.setCapability();
        options.setPageLoadStrategy();
        options.setProxy();
        options.setStrictFileInteractability();
        options.setUnhandledPromptBehaviour();
        options.setUseTechnologyPreview();
        */
        driver = new SafariDriver(safariDriverService, options);
    }
}
