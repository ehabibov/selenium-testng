package com.ehabibov.driver.manager.browser;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Capabilities;

import com.ehabibov.driver.manager.RemoteDriverManagerLifecycle;
import com.ehabibov.driver.config.OptionsFetcher;
import com.ehabibov.driver.config.browser.RemoteOptionsHolder;
import com.ehabibov.driver.CapabilitiesPrinter;

public class RemoteDriverManager extends RemoteDriverManagerLifecycle {

    private OptionsFetcher optionsFetcher = new OptionsFetcher(RemoteOptionsHolder.class);
    private Capabilities capabilities;

    @Override
    protected void prepareService() {
        capabilities = optionsFetcher.getOptions();
    }

    public void createDriver() {
        driver = new RemoteWebDriver(this.getURL(), capabilities);
        new CapabilitiesPrinter(driver).printCapabilities();
    }

    private java.net.URL getURL() {
        java.net.URL url = null;
        try {
            url = new java.net.URL("http://localhost:4444/wd/hub");
        } catch (java.net.MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}