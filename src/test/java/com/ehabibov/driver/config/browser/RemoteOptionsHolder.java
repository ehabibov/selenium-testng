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

    public void setBrowserType(String browserType){
        options.setCapability("browserName", browserType);
    }

    public void setBrowserVersion(String browserVersion){
        options.setCapability("version", browserVersion);
    }

    public void setExecutionName(String executionName){
        options.setCapability("name", executionName);
    }

    public void setEnableVNC(boolean enableVNC){
        options.setCapability("enableVNC", enableVNC);
    }

    public void setEnableLogging(boolean enableLogging){
        options.setCapability("enableLog", enableLogging);
        options.setCapability("logName", this.setLogNameFormat());
    }

    public void setEnableRecording(boolean enableRecording){
        options.setCapability("enableVideo", enableRecording);
        options.setCapability("videoName", this.setVideoNameFormat());
    }

    public void setRecordingFramerate(String framerate){
        options.setCapability("videoFrameRate", Integer.valueOf(framerate));
    }

    private String currentTimestamp() {
        return new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss.SSS").format(new Date());
    }

    private String setLogNameFormat(){
        return String.format(this.logFormat, this.timeStamp);
    }

    private String setVideoNameFormat(){
        return String.format(this.videoFormat, this.timeStamp);
    }

    private void setCapabilityIfNotNull(String key, Object value){
        if (value != null){
            options.setCapability(key, value);
        }
    }
}