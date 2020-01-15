package com.ehabibov.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class HomePageOR implements LocatorRepository {

    private static By trait = By.cssSelector("nav.navbar");

    @FindBy(css = "nav.navbar") private WebElement mainBar;

    public WebElement getMainBar() { return mainBar; }

    public static By getTrait(){
        return trait;
    }
}
