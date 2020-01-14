package com.ehabibov.driver.config;

import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.Proxy;
import java.util.List;
import java.io.File;

public class IeDriverConfig implements DriverConfig {

    private InternetExplorerOptions options;
    private String port;
    private List<String> args;
    private List<File> extensions;
    private boolean headless;
    private boolean acceptInsecureCerts;
    private Proxy proxy;

    public void initOptions(){
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.addCommandSwitches();
        options.destructivelyEnsureCleanSession();
        options.disableNativeEvents();
        options.elementScrollTo();
        options.enablePersistentHovering();
        options.ignoreZoomSettings();
        options.introduceFlakinessByIgnoringSecurityDomains();
        options.requireWindowFocus();
        options.setCapability();
        options.setPageLoadStrategy();
        options.setProxy(proxy);
        options.setStrictFileInteractability();
        options.setUnhandledPromptBehaviour();
        options.takeFullPageScreenshot();
        options.useCreateProcessApiToLaunchIe();
        options.usePerProcessProxy();
        options.useShellWindowsApiToAttachToIe();
        options.waitForUploadDialogUpTo();
        options.withAttachTimeout();
        options.withInitialBrowserUrl();
        options.asMap();
    }

    public InternetExplorerOptions getOptions() {
        this.initOptions();
        return this.options;
    }

    public Proxy setProxy(){
        proxy = new Proxy();
        proxy.setAutodetect();
        proxy.setFtpProxy();
        proxy.setHttpProxy();
        proxy.setNoProxy();
        proxy.setProxyAutoconfigUrl();
        proxy.setProxyType(Proxy.ProxyType.valueOf());
        proxy.setSocksProxy();
        proxy.setSocksUsername();
        proxy.setSocksVersion();
        proxy.setSslProxy();
    }
}
