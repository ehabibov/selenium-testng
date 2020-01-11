package com.ehabibov.driver.manager.browser;

import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import java.io.File;
import java.io.IOException;

import com.ehabibov.driver.manager.DriverManager;
import com.ehabibov.driver.config.OperaDriverConfig;

public class OperaDriverManager extends DriverManager {

    private OperaDriverService operaDriverService;
    private OperaDriverConfig operaDriverConfig;

    public void setOperaDriverConfig(OperaDriverConfig operaDriverConfig) {
        this.operaDriverConfig = operaDriverConfig;
    }

    @Override
    protected void prepareService() {
        if (operaDriverService == null) {
            driverBinaryConfig.init();
            operaDriverService = new OperaDriverService.Builder()
                    .usingDriverExecutable(new File(driverBinaryConfig.getBinaryPath()))
                    .usingAnyFreePort()
                    .build();
        }
    }

    @Override
    public void startService() {
        try {
            operaDriverService.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stopService() {
        if (operaDriverService !=null && operaDriverService.isRunning())
            operaDriverService.stop();
    }

    @Override
    public void createDriver() {
        OperaOptions options = new OperaOptions();
        /*
        options.addArguments();
        options.addExtensions();
        options.addEncodedExtensions();
        options.setAcceptInsecureCerts();
        options.setBinary();
        options.setCapability();
        options.setCapability();
        options.setExperimentalOption();
        options.setPageLoadStrategy();
        options.setProxy();
        options.setStrictFileInteractability();
        options.setUnhandledPromptBehaviour();
        */
        driver = new OperaDriver(operaDriverService, options);
    }

}