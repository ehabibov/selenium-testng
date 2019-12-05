package com.ehabibov.driver.manager;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver;
    protected abstract void prepareService();
    protected abstract void startService();
    protected abstract void stopService();
    protected abstract void createDriver();

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
    }
}