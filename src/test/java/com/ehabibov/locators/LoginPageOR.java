package com.ehabibov.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageOR implements LocatorRepository {

    private By user = By.cssSelector("input[type='text']");

    @FindBy(css = "input[type='text']") private WebElement username;
    @FindBy(css = "input[type='password']") private WebElement password;
    @FindBy(css = "input[type='submit']") private WebElement button;

    public WebElement getUsername() { return username; }
    public WebElement getPassword() { return password; }
    public WebElement getButton() { return button; }
}
