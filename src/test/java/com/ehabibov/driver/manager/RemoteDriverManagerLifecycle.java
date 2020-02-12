package com.ehabibov.driver.manager;

import org.openqa.selenium.WebDriver;

public abstract class RemoteDriverManagerLifecycle extends DriverManagerLifecycle {

    public WebDriver getDriver() {
        if (driver == null) {
            this.prepareService();
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