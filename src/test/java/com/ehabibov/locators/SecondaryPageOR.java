package com.ehabibov.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecondaryPageOR implements LocatorRepository {

    @FindBy(id = "main_nav")            public WebElement navigationBar;
    @FindBy(linkText = "Widget")        public WebElement widget;

}