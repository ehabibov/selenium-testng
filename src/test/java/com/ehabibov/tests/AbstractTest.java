package com.ehabibov.tests;

import com.ehabibov.listeners.SeleniumSuiteListener;
import com.ehabibov.listeners.SeleniumTestListener;
import org.springframework.context.ApplicationContext;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.ehabibov.context.ApplicationContextSingleton;
import com.ehabibov.driver.manager.DriverManager;


@Listeners({SeleniumSuiteListener.class, SeleniumTestListener.class})
public abstract class AbstractTest {

    protected ApplicationContext context;
    protected DriverManager manager;
    protected WebDriver driver;

    @BeforeSuite
    public void getCtx(){
        context = ApplicationContextSingleton.getContext();
        manager = (DriverManager) context.getBean("driverManager");
        driver = manager.getDriver();
    }
}