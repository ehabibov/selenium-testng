package com.ehabibov.tests;

import org.springframework.context.ApplicationContext;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import com.ehabibov.context.ApplicationContextSingleton;

public abstract class AbstractTest {

    protected ApplicationContext context;
    protected WebDriver driver;

    @BeforeSuite
    public void getCtx(){
        context = ApplicationContextSingleton.getContext();
        driver = (WebDriver) context.getBean("webDriver");
    }
}