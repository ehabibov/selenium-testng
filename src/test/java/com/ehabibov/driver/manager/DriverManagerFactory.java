package com.ehabibov.driver.manager;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;

import com.ehabibov.context.ApplicationContextSingleton;
import com.ehabibov.driver.manager.browser.*;
import com.ehabibov.driver.DriverType;

public class DriverManagerFactory implements FactoryBean<DriverManagerLifecycle> {

    private DriverType driverType;

    @Override
    public DriverManagerLifecycle getObject() {
        ApplicationContext context = ApplicationContextSingleton.getContext();
        DriverManagerLifecycle driverManager;
        switch (driverType) {
            case CHROME:
                driverManager = context.getBean(ChromeDriverManager.class);
                break;
            case FIREFOX:
                driverManager = context.getBean(FirefoxDriverManager.class);
                break;
            case OPERA:
                driverManager = context.getBean(OperaDriverManager.class);
                break;
            case IE:
                driverManager = context.getBean(InternetExplorerDriverManager.class);
                break;
            case EDGE:
                driverManager = context.getBean(EdgeDriverManager.class);
                break;
            case SAFARI:
                driverManager = context.getBean(SafariDriverManager.class);
                break;
            default:
                throw new IllegalArgumentException("Browser not exists: " + driverType.toString());
        }
        return driverManager;
    }

    @Override
    public Class<DriverManagerLifecycle> getObjectType() {
        return DriverManagerLifecycle.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setDriverType(final String driverType) {
        this.driverType = DriverType.valueOf(driverType.toUpperCase());
    }

}