package com.ehabibov.pageobjects;

import org.springframework.context.ApplicationContext;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.ehabibov.listeners.driver.DriverListener;
import com.ehabibov.context.ApplicationContextProvider;
import com.ehabibov.driver.manager.DriverManager;
import com.ehabibov.locators.LocatorRepository;

public abstract class AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(AbstractPage.class);

    protected ApplicationContext context;
    protected DriverManager<?> manager;
    protected EventFiringWebDriver driver;

    public AbstractPage(){
        this.initDriver();
    }

    void initDriver(){
        this.context = ApplicationContextProvider.getApplicationContext();
        this.manager = (DriverManager<?>) context.getBean("driverManager");
        this.driver = new EventFiringWebDriver(manager.getDriver());
        this.driver.register(new DriverListener());
    }

    void initPage(LocatorRepository locatorRepository){
        PageFactory.initElements(driver, locatorRepository);
    }

    protected <T extends LocatorRepository> T setObjectRepository(Class<T> type) {
        T instance;
        try {
            instance =  type.newInstance();
            return instance;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}