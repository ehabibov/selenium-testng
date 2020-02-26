package com.ehabibov.driver.manager;

import org.openqa.selenium.WebDriver;
import com.ehabibov.driver.binary.DriverBinaryConfig;

public abstract class CommonDriverManagerLifecycle extends DriverManagerLifecycle {

    protected DriverBinaryConfig driverBinaryConfig;
    protected abstract void startService();
    protected abstract void stopService();

    public WebDriver getDriver() {
        if (driver == null) {
            this.prepareService();
            this.startService();
            this.createDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        this.stopService();
    }

    public void setBinaryConfig(final DriverBinaryConfig driverBinaryConfig) {
        this.driverBinaryConfig = driverBinaryConfig;
    }
}