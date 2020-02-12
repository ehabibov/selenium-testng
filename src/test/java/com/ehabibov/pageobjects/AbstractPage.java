package com.ehabibov.pageobjects;

import org.springframework.context.ApplicationContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.time.Duration;

import com.ehabibov.context.ApplicationContextSingleton;
import com.ehabibov.driver.config.ApplicationConfig;
import com.ehabibov.driver.manager.DriverManagerHolder;
import com.ehabibov.driver.manager.DriverManagerLifecycle;
import com.ehabibov.locators.LocatorRepository;

public abstract class AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(AbstractPage.class);

    protected ApplicationContext context;
    protected ApplicationConfig appConfig;
    protected DriverManagerLifecycle manager;
    protected EventFiringWebDriver driver;

    public AbstractPage(){
        this.initDriver();
    }

    void initDriver(){
        this.context = ApplicationContextSingleton.getContext();
        this.appConfig = context.getBean(ApplicationConfig.class);
        this.driver = DriverManagerHolder.Driver.getDriver();
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

    public void waitForElementExist(By locator, long timeout, long interval){
        String locatorAddress = this.getLocatorAddress(locator);
        String message = String.format("WebElement not found [%s]", locatorAddress);
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(interval))
                .ignoring(NoSuchElementException.class)
                .withMessage(message)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private String getLocatorAddress(By locator) {
        String locatorAddress = "[not init]";
        if (locator instanceof By.ByCssSelector) {
            locatorAddress = ((By.ByCssSelector) locator).toString();
        } else if (locator instanceof By.ByClassName) {
            locatorAddress = ((By.ByClassName) locator).toString();
        } else if (locator instanceof By.ByXPath) {
            locatorAddress = ((By.ByXPath) locator).toString();
        } else if (locator instanceof By.ById) {
            locatorAddress = ((By.ById) locator).toString();
        } else if (locator instanceof By.ByName) {
            locatorAddress = ((By.ByName) locator).toString();
        } else if (locator instanceof By.ByLinkText) {
            locatorAddress = ((By.ByLinkText) locator).toString();
        } else if (locator instanceof By.ByPartialLinkText) {
            locatorAddress = ((By.ByPartialLinkText) locator).toString();
        } else if (locator instanceof By.ByTagName) {
            locatorAddress = ((By.ByTagName) locator).toString();
        }
        return locatorAddress;
    }
}