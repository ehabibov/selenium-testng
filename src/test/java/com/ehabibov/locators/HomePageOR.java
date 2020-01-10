package com.ehabibov.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageOR implements LocatorRepository {

    @FindBy(css = "nav.navbar") private WebElement mainBar;

    public WebElement getMainBar() { return mainBar; }
}
