package com.ehabibov.driver.manager;

import org.springframework.context.ApplicationContext;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ehabibov.context.ApplicationContextSingleton;
import com.ehabibov.driver.config.ApplicationConfig;

public class DriverManagerHolder {

    private static DriverManagerLifecycle manager = initManager();
    private static ApplicationContext context;

    private DriverManagerHolder() { }

    public static DriverManagerLifecycle getManager(){
        return manager;
    }

    private static DriverManagerLifecycle driverManagerPicker(ApplicationConfig config){
        return manager = config.isRemoteDriver()
                ? context.getBean("remoteDriverManager", RemoteDriverManagerLifecycle.class)
                : context.getBean("driverManager", CommonDriverManagerLifecycle.class);
    }

    private static DriverManagerLifecycle initManager (){
        context = ApplicationContextSingleton.getContext();
        return driverManagerPicker(context.getBean(ApplicationConfig.class));
    }

    public static final class Driver {
        private static EventFiringWebDriver driver = initDriver();

        public static EventFiringWebDriver getDriver(){
            if (driver == null){
                driver = initDriver();
            }
            return driver;
        }

        public static void quitDriver(){
            manager.quitDriver();
        }

        private static EventFiringWebDriver initDriver(){
            return new EventFiringWebDriver(manager.getDriver());
        }
    }

}