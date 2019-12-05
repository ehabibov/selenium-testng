package com.ehabibov.pageobjects;

import org.springframework.context.ApplicationContext;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.ehabibov.context.ApplicationContextProvider;
import com.ehabibov.locators.LocatorRepository;

public abstract class AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(AbstractPage.class);

    protected ApplicationContext context;
    protected WebDriver driver;

    public AbstractPage(){
        initDriver();
    }

    void initDriver(){
        this.context = ApplicationContextProvider.getApplicationContext();
        this.driver = (WebDriver) context.getBean("webDriver");
    }

    void initPage(WebDriver driver, LocatorRepository locatorRepository){
        PageFactory.initElements(driver, locatorRepository);
    }
}