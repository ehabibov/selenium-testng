package com.ehabibov.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class CapabilitiesPrinter {

    private static final Logger log = LoggerFactory.getLogger(CapabilitiesPrinter.class);

    private WebDriver driver;

    public CapabilitiesPrinter(WebDriver driver) {
        this.driver = driver;
    }

    public void printCapabilities(){
        Capabilities capabilities = ((ChromeDriver) this.driver).getCapabilities();

        Set<String> capabilityNames = capabilities.getCapabilityNames();
        for (String capabilityName : capabilityNames){
            log.warn(capabilityName.concat(" : ").concat(capabilities.getCapability(capabilityName).toString()));
        }
    }


}
