package com.ehabibov.driver.config.browser;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Proxy;

import java.util.List;
import java.io.File;

public class ChromeDriverConfig implements DriverConfig {

    private ChromeOptions options;
    private String port;
    private List<String> args;
    private List<File> extensions;
    private List<String> encodedExtensions;
    private boolean headless;
    private boolean acceptInsecureCerts;
    private Proxy proxy;

    public void initOptions() {
        /*options = new ChromeOptions();
        options.addArguments(args);
        options.addExtensions(extensions);
        options.addEncodedExtensions(encodedExtensions);
        options.setAcceptInsecureCerts(acceptInsecureCerts);
        options.setBinary();
        options.setCapability();
        options.setExperimentalOption();
        options.setHeadless(headless);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.setStrictFileInteractability(true);
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        options.setProxy(proxy);*/
    }

    public ChromeOptions getOptions() {
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