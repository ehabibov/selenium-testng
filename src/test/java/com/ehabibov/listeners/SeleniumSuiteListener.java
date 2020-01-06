package com.ehabibov.listeners;

import org.springframework.context.ApplicationContext;
import org.openqa.selenium.WebDriver;
import org.testng.ISuiteListener;
import org.testng.ISuite;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.ehabibov.context.ApplicationContextSingleton;
import com.ehabibov.context.ApplicationContextProvider;
import com.ehabibov.driver.manager.DriverManager;

public class SeleniumSuiteListener implements ISuiteListener {

    private static final Logger log = LoggerFactory.getLogger(SeleniumSuiteListener.class);

    protected ApplicationContext context;
    protected DriverManager manager;
    protected WebDriver driver;

    @Override
    public void onStart(ISuite suiteContext) {
        log.info("suite onStart");
        this.context = ApplicationContextSingleton.getContext();
        this.manager = (DriverManager) this.context.getBean("driverManager");
        this.driver = this.manager.getDriver();
    }

    @Override
    public void onFinish(ISuite suiteContext) {
        log.info("suite onFinish");
        this.context = ApplicationContextProvider.getApplicationContext();
        this.manager = (DriverManager) this.context.getBean("driverManager");
        this.manager.quitDriver();
    }

}
