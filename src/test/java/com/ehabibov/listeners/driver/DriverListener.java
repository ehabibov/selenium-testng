package com.ehabibov.listeners.driver;

import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class DriverListener extends AbstractWebDriverEventListener {

    private static final Logger log = LoggerFactory.getLogger(DriverListener.class);

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        String attributes = this.getTemplate(element);
        String attributesJs = this.getAttributesByJavascript(element, driver);
        log.info(String.format("Clicked on: element%s attributes%s", attributes, attributesJs));
    }

    private String getTemplate(WebElement element){
        return String.format("[tag = '%s', text = '%s']", element.getTagName(), element.getText());
    }

    private String getAttributesByJavascript(WebElement element, WebDriver driver){
        String script = "var items = {};" +
                "for (index = 0; index < arguments[0].attributes.length; ++index)" +
                "{ items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }" +
                "return items;";
        return ((JavascriptExecutor) driver).executeScript(script, element).toString();
    }
}
