package com.ehabibov.driver.config.browser;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.Proxy;
import java.util.List;
import java.io.File;

public class FirefoxDriverConfig implements DriverConfig {

    private FirefoxOptions options;
    private String port;
    private List<String> args;
    private List<File> extensions;
    private boolean headless;
    private boolean acceptInsecureCerts;
    private Proxy proxy;

    public void initOptions(){
        options = new FirefoxOptions();
        /*options.addArguments(args);
        options.addPreference();
        options.setAcceptInsecureCerts(acceptInsecureCerts);
        options.setBinary();
        options.setCapability();
        options.setHeadless(headless);
        options.setLegacy();
        options.setLogLevel()
        options.setPageLoadStrategy();
        options.setProfile();
        options.setProxy(proxy);
        options.setStrictFileInteractability();
        options.setUnhandledPromptBehaviour();*/
    }

    public FirefoxOptions getOptions() {
        this.initOptions();
        return this.options;
    }

    public Proxy setProxy(){
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

    public void setPort(String port) {
        this.port = port;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }
}
