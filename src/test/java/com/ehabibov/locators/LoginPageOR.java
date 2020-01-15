package com.ehabibov.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageOR implements LocatorRepository {

    @FindBy(css = "input[type='text']") private WebElement username;
    @FindBy(css = "input[type='password']") private WebElement password;
    @FindBy(css = "input[type='submit']") private WebElement button;

    public WebElement getUsername() { return username; }
    public WebElement getPassword() { return password; }
    public WebElement getButton() { return button; }
}
