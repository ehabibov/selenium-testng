package com.ehabibov.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class SeleniumTestListener implements ITestListener {

    private static final Logger log = LoggerFactory.getLogger(SeleniumTestListener.class);

    @Override
    public void onStart(ITestContext context) {
        log.info("test onStart");
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

}
