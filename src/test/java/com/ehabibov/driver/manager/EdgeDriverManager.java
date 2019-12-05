package com.ehabibov.driver.manager;

import org.openqa.selenium.edge.ChromiumEdgeDriverService;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.File;
import java.io.IOException;

import com.ehabibov.driver.binary.EdgeBinaryConfig;
import com.ehabibov.driver.config.EdgeDriverConfig;

public class EdgeDriverManager extends DriverManager {

    private EdgeDriverService edgeDriverService;
    private EdgeBinaryConfig edgeBinaryConfig;
    private EdgeDriverConfig edgeDriverConfig;

    public void setEdgeBinaryConfig(EdgeBinaryConfig edgeBinaryConfig) {
        this.edgeBinaryConfig = edgeBinaryConfig;
    }

    public void setEdgeDriverConfig(EdgeDriverConfig edgeDriverConfig) {
        this.edgeDriverConfig = edgeDriverConfig;
    }

    @Override
    protected void prepareService() {
        if (edgeDriverService == null) {
            edgeBinaryConfig.construct();
            edgeBinaryConfig.init();
            edgeDriverService = new ChromiumEdgeDriverService.Builder()
                    .usingDriverExecutable(new File(edgeBinaryConfig.getBinaryPath()))
                    .usingAnyFreePort()
                    .build();
        }
    }

    @Override
    public void startService() {
        try {
            edgeDriverService.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stopService() {
        if (edgeDriverService != null && edgeDriverService.isRunning())
            edgeDriverService.stop();
    }

    @Override
    public void createDriver() {
        EdgeOptions options = new EdgeOptions();
        /*
        options.addArguments();
        options.addEncodedExtensions();
        options.addExtensions();
        options.setBinary();
        options.setCapability();
        options.setExperimentalOption()
        options.setHeadless();
        options.setPageLoadStrategy();
        options.setProxy();
        options.setStrictFileInteractability();
        options.setUnhandledPromptBehaviour();
        options.asMap();
        */
        driver = new RemoteWebDriver(edgeDriverService.getUrl(), options);
    }

}