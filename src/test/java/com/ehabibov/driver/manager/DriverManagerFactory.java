package com.ehabibov.driver.manager;

import org.springframework.beans.factory.FactoryBean;

import com.ehabibov.driver.manager.browser.*;
import com.ehabibov.driver.DriverType;

public class DriverManagerFactory implements FactoryBean<DriverManager<?>> {

    public DriverType driverType;
    public ChromeDriverManager chromeDriverManager;
    public FirefoxDriverManager firefoxDriverManager;
    public SafariDriverManager safariDriverManager;
    public InternetExplorerDriverManager internetExplorerDriverManager;
    public EdgeDriverManager edgeDriverManager;
    public OperaDriverManager operaDriverManager;

    @Override
    public DriverManager<?> getObject() {
        DriverManager<?> driverManager;
        switch (driverType) {
            case CHROME:
                driverManager = this.chromeDriverManager;
                break;
            case FIREFOX:
                driverManager = this.firefoxDriverManager;
                break;
            case OPERA:
                driverManager = this.operaDriverManager;
                break;
            case IE:
                driverManager = this.internetExplorerDriverManager;
                break;
            case EDGE:
                driverManager = this.edgeDriverManager;
                break;
            case SAFARI:
                driverManager = this.safariDriverManager;
                break;
            default:
                throw new IllegalArgumentException("Browser not exists: " + driverType.toString());
        }
        return driverManager;
    }

    @Override
    public Class<DriverManager> getObjectType() {
        return DriverManager.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setDriverType(String driverType) {
        this.driverType = DriverType.valueOf(driverType.toUpperCase()) ;
    }

    public void setChromeDriverManager(ChromeDriverManager chromeDriverManager) {
        this.chromeDriverManager = chromeDriverManager;
    }

    public void setFirefoxDriverManager(FirefoxDriverManager firefoxDriverManager) {
        this.firefoxDriverManager = firefoxDriverManager;
    }

    public void setSafariDriverManager(SafariDriverManager safariDriverManager) {
        this.safariDriverManager = safariDriverManager;
    }

    public void setInternetExplorerDriverManager(InternetExplorerDriverManager internetExplorerDriverManager) {
        this.internetExplorerDriverManager = internetExplorerDriverManager;
    }

    public void setEdgeDriverManager(EdgeDriverManager edgeDriverManager) {
        this.edgeDriverManager = edgeDriverManager;
    }

    public void setOperaDriverManager(OperaDriverManager operaDriverManager) {
        this.operaDriverManager = operaDriverManager;
    }
}
