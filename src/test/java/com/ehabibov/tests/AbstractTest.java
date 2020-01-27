package com.ehabibov.tests;

import org.springframework.context.ApplicationContext;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.ehabibov.context.ApplicationContextSingleton;
import com.ehabibov.driver.config.ApplicationConfig;
import com.ehabibov.driver.manager.DriverManager;
import com.ehabibov.listeners.test.SeleniumSuiteListener;
import com.ehabibov.listeners.test.SeleniumTestListener;

@Listeners({SeleniumSuiteListener.class, SeleniumTestListener.class})
public abstract class AbstractTest {

    protected ApplicationContext context;
    protected ApplicationConfig appConfig;
    protected DriverManager<?> manager;
    protected WebDriver driver;

    @BeforeSuite
    public void getCtx(){
        context = ApplicationContextSingleton.getContext();
        manager = (DriverManager<?>) context.getBean("driverManager");
        appConfig = context.getBean(ApplicationConfig.class);
        driver = manager.getDriver();
    }
}