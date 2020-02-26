package com.ehabibov.listeners.driver;

import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Arrays;

public class DriverListener extends AbstractWebDriverEventListener {

    private static final Logger log = LoggerFactory.getLogger(DriverListener.class);

    @Override
    public void beforeChangeValueOf(final WebElement element, final WebDriver driver, final CharSequence[] keysToSend) {
        log.info(String.format("Sending keys: %s", Arrays.toString(keysToSend)));
    }

    @Override
    public void beforeClickOn(final WebElement element, final WebDriver driver) {
        String attributes = this.getTemplate(element);
        String attributesJs = this.getAttributesByJavascript(element, driver);
        log.info(String.format("Clicking on: element%s attributes%s", attributes, attributesJs));
    }

    private String getTemplate(final WebElement element) {
        return String.format("[tag = '%s', text = '%s']", element.getTagName(), element.getText());
    }

    private String getAttributesByJavascript(final WebElement element, final WebDriver driver) {
        String script = "let items = {};" +
                "for (let index = 0; index < arguments[0].attributes.length; ++index)" +
                "{ items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }" +
                "return items;";
        return ((JavascriptExecutor) driver).executeScript(script, element).toString();
    }
}
