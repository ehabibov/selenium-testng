package com.ehabibov.listeners.test;

import org.openqa.selenium.WebDriver;
import org.testng.ISuiteListener;
import org.testng.ISuite;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.ehabibov.driver.manager.DriverManagerHolder;
import com.ehabibov.listeners.driver.DriverListener;

public class SeleniumSuiteListener implements ISuiteListener {

    private static final Logger log = LoggerFactory.getLogger(SeleniumSuiteListener.class);

    @Override
    public void onStart(ISuite suiteContext) {
        log.info("suite onStart");
        WebDriver driver = DriverManagerHolder.Driver.getDriver().register(new DriverListener());
        driver.manage().window().maximize();
    }

    @Override
    public void onFinish(ISuite suiteContext) {
        log.info("suite onFinish");
        DriverManagerHolder.Driver.quitDriver();
    }

}