package com.ehabibov.listeners.test;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import io.qameta.allure.Allure;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.ehabibov.driver.manager.DriverManagerHolder;

public class SeleniumTestListener implements ITestListener {

    private static final Logger log = LoggerFactory.getLogger(SeleniumTestListener.class);

    protected WebDriver driver;

    @Override
    public void onStart(ITestContext context) {
        log.info("test onStart");
        this.driver = DriverManagerHolder.Driver.getDriver();
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("test onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("test onTestSuccess");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("test onTestSkipped");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("test onTestFailure");
        this.takeScreenshot();
        this.takePageSource();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.info("test onTestFailedButWithinSuccessPercentage");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        log.info("test onTestFailedWithTimeout");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("test onFinish");
    }

    private void takeScreenshot(){
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            InputStream is = new FileInputStream(screenshot);
            Allure.addAttachment("Page screenshot", "image/jpeg", is, "jpeg");
            log.info("Saved screenshot");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void takePageSource(){
        String pageSource = driver.getPageSource();
        Allure.addAttachment("Page source", "text/plain", pageSource, "txt");
        log.info("Saved page source");
    }
}