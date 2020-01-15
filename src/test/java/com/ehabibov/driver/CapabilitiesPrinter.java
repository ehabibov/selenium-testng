package com.ehabibov.driver;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.Set;

public class CapabilitiesPrinter {

    private static final Logger log = LoggerFactory.getLogger(CapabilitiesPrinter.class);

    private WebDriver driver;

    public CapabilitiesPrinter(WebDriver driver) {
        this.driver = driver;
    }

    public void printCapabilities(){
        Capabilities capabilities = ((RemoteWebDriver) this.driver).getCapabilities();
        String output="Capabilities:\n";
        Set<String> capabilityNames = capabilities.getCapabilityNames();
        for (String capabilityName : capabilityNames){
            String capabilityValue = capabilities.getCapability(capabilityName).toString();
            String capabilityOutput = String.format("\t%s : %s\n", capabilityName, capabilityValue);
            output = output.concat(capabilityOutput);
        }
        log.warn(output);
    }
}