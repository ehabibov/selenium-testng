package com.ehabibov.driver.config.browser;

import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.Proxy;

import java.util.List;
import java.io.File;

public class SafariDriverConfig implements DriverConfig {

    private SafariOptions options;
    private String port;
    private List<String> args;
    private List<File> extensions;
    private boolean headless;
    private boolean acceptInsecureCerts;
    private Proxy proxy;

    public void initOptions() {
        options = new SafariOptions();
        /*options.setAcceptInsecureCerts();
        options.setAutomaticInspection();
        options.setAutomaticProfiling();
        options.setCapability();
        options.setPageLoadStrategy();
        options.setProxy(proxy);
        options.setStrictFileInteractability();
        options.setUnhandledPromptBehaviour();
        options.setUseTechnologyPreview();*/
    }

    public SafariOptions getOptions() {
        this.initOptions();
        return this.options;
    }

    public Proxy setProxy() {
        /*proxy = new Proxy();
        proxy.setAutodetect();
        proxy.setFtpProxy();
        proxy.setHttpProxy();
        proxy.setNoProxy();
        proxy.setProxyAutoconfigUrl();
        proxy.setProxyType(Proxy.ProxyType.valueOf());
        proxy.setSocksProxy();
        proxy.setSocksUsername();
        proxy.setSocksVersion();
        proxy.setSslProxy();*/
        return proxy;
    }

    public void setPort(final String port) {
        this.port = port;
    }

    public void setArgs(final List<String> args) {
        this.args = args;
    }
}