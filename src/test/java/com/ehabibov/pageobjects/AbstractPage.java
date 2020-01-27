package com.ehabibov.pageobjects;

import org.springframework.context.ApplicationContext;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.ehabibov.context.ApplicationContextProvider;
import com.ehabibov.driver.config.ApplicationConfig;
import com.ehabibov.driver.manager.DriverManager;
import com.ehabibov.locators.LocatorRepository;
import com.ehabibov.listeners.driver.DriverListener;

public abstract class AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(AbstractPage.class);

    protected ApplicationContext context;
    protected ApplicationConfig appConfig;
    protected DriverManager<?> manager;
    protected EventFiringWebDriver driver;

    public AbstractPage(){
        this.initDriver();
    }

    void initDriver(){
        this.context = ApplicationContextProvider.getApplicationContext();
        this.appConfig = context.getBean(ApplicationConfig.class);
        this.manager = (DriverManager<?>) context.getBean("driverManager");
        this.driver = new EventFiringWebDriver(manager.getDriver());
        this.driver.register(new DriverListener());
    }

    void initPage(LocatorRepository locatorRepository){
        PageFactory.initElements(driver, locatorRepository);
    }

    protected <T extends LocatorRepository> T setObjectRepository(Class<T> type) {
        T instance = null;
        try {
            instance =  type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return instance;
    }

    protected String getAppUrl(){
        return String.format("%s:%s", appConfig.getApplicationHost(), appConfig.getApplicationPort());
    }

    protected String getBrowser(){
        return this.appConfig.getBrowserType();
    }

    public boolean isSafari(){
        return this.getBrowser().equalsIgnoreCase("safari");
    }

    public boolean isNotSafari(){
        return !this.isSafari();
    }
}