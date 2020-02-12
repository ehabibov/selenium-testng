package com.ehabibov.driver.manager;

import org.openqa.selenium.WebDriver;

public abstract class DriverManagerLifecycle {

    protected WebDriver driver;
    protected abstract void prepareService();
    protected abstract void createDriver();

    protected abstract WebDriver getDriver();
    protected abstract void quitDriver();

}