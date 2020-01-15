package com.ehabibov.driver.config;

import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.Proxy;
import java.util.List;
import java.io.File;

public class OperaDriverConfig implements DriverConfig {

    private OperaOptions options;
    private String port;
    private List<String> args;
    private List<File> extensions;
    private boolean headless;
    private boolean acceptInsecureCerts;
    private Proxy proxy;

    public void initOptions(){
        options = new OperaOptions();
        /*options.addArguments(args);
        options.addExtensions(extensions);
        options.addEncodedExtensions();
        options.setAcceptInsecureCerts(acceptInsecureCerts);
        options.setBinary();
        options.setCapability();
        options.setExperimentalOption();
        options.setPageLoadStrategy();
        options.setProxy(proxy);
        options.setStrictFileInteractability();
        options.setUnhandledPromptBehaviour();*/
    }

    public OperaOptions getOptions() {
        this.initOptions();
        return this.options;
    }

    public Proxy setProxy(){
    /*    proxy = new Proxy();
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
