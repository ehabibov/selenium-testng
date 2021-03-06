package com.ehabibov.driver.config.browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ehabibov.driver.config.OptionsHolder;

public class RemoteOptionsHolder implements OptionsHolder {

    private DesiredCapabilities options = new DesiredCapabilities();
    private String timeStamp = this.currentTimestamp();
    private String logFormat = "log-%s.log";
    private String videoFormat = "video-%s.mp4";

    @Override
    public Capabilities getOptions() {
        return this.options;
    }

    public void setBrowserType(final String browserType) {
        options.setCapability("browserName", browserType);
    }

    public void setBrowserVersion(final String browserVersion) {
        options.setCapability("version", browserVersion);
    }

    public void setExecutionName(final String executionName) {
        options.setCapability("name", executionName);
    }

    public void setEnableVNC(final boolean enableVNC) {
        options.setCapability("enableVNC", enableVNC);
    }

    public void setEnableLogging(final boolean enableLogging) {
        options.setCapability("enableLog", enableLogging);
        options.setCapability("logName", this.setLogNameFormat());
    }

    public void setEnableRecording(final boolean enableRecording) {
        options.setCapability("enableVideo", enableRecording);
        options.setCapability("videoName", this.setVideoNameFormat());
    }

    public void setRecordingFramerate(final String framerate) {
        options.setCapability("videoFrameRate", Integer.valueOf(framerate));
    }

    private String currentTimestamp() {
        return new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss.SSS").format(new Date());
    }

    private String setLogNameFormat() {
        return String.format(this.logFormat, this.timeStamp);
    }

    private String setVideoNameFormat() {
        return String.format(this.videoFormat, this.timeStamp);
    }

    private void setCapabilityIfNotNull(final String key, final Object value) {
        if (value != null) {
            options.setCapability(key, value);
        }
    }
}