package com.ehabibov.driver.manager;

import org.springframework.beans.factory.FactoryBean;
import com.ehabibov.driver.DriverType;

public class DriverManagerFactory implements FactoryBean<DriverManager> {

    public DriverType driverType;
    public ChromeDriverManager chromeDriverManager;
    public FirefoxDriverManager firefoxDriverManager;
    public SafariDriverManager safariDriverManager;
    public IeDriverManager ieDriverManager;
    public EdgeDriverManager edgeDriverManager;
    public OperaDriverManager operaDriverManager;

    @Override
    public DriverManager getObject() {
        DriverManager driverManager;
        switch (driverType) {
            case CHROME:
                driverManager = this.chromeDriverManager;
                break;
            case FIREFOX:
                driverManager = this.firefoxDriverManager;
                break;
            case SAFARI:
                driverManager = this.safariDriverManager;
                break;
            case IE:
                driverManager = this.ieDriverManager;
                break;
            case EDGE:
                driverManager = this.edgeDriverManager;
                break;
            case OPERA:
                driverManager = this.operaDriverManager;
                break;
            default:
                throw new NullPointerException();
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

    public void setDriverType(DriverType driverType) {
        this.driverType = driverType;
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

    public void setIeDriverManager(IeDriverManager ieDriverManager) {
        this.ieDriverManager = ieDriverManager;
    }

    public void setEdgeDriverManager(EdgeDriverManager edgeDriverManager) {
        this.edgeDriverManager = edgeDriverManager;
    }

    public void setOperaDriverManager(OperaDriverManager operaDriverManager) {
        this.operaDriverManager = operaDriverManager;
    }
}
