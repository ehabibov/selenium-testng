package com.ehabibov.driver.manager;

import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import java.io.File;
import java.io.IOException;

import com.ehabibov.driver.binary.IeBinaryConfig;
import com.ehabibov.driver.config.IeDriverConfig;

public class IeDriverManager extends DriverManager {

    private InternetExplorerDriverService ieDriverService;
    private IeBinaryConfig ieBinaryConfig;
    private IeDriverConfig ieDriverConfig;

    public void setIeBinaryConfig(IeBinaryConfig ieBinaryConfig) {
        this.ieBinaryConfig = ieBinaryConfig;
    }

    public void setIeDriverConfig(IeDriverConfig ieDriverConfig) {
        this.ieDriverConfig = ieDriverConfig;
    }

    @Override
    protected void prepareService() {
        if (ieDriverService == null) {
            ieBinaryConfig.construct();
            ieBinaryConfig.init();
            ieDriverService = new InternetExplorerDriverService.Builder()
                    .usingDriverExecutable(new File(ieBinaryConfig.getBinaryPath()))
                    .usingAnyFreePort()
                    .build();
        }
    }

    @Override
    public void startService() {
        try {
            ieDriverService.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stopService() {
        if (ieDriverService !=null && ieDriverService.isRunning())
            ieDriverService.stop();
    }

    @Override
    public void createDriver() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        /*
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
        options.setProxy();
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
        */
        driver = new InternetExplorerDriver(ieDriverService, options);
    }

}