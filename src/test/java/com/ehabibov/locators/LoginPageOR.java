package com.ehabibov.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageOR implements LocatorRepository {

    @FindBy(id = "txtUsername") private WebElement username;
    @FindBy(id = "txtPassword") private WebElement password;
    @FindBy(id = "btnLogin") private WebElement button;

    public WebElement getUsername() { return username; }
    public WebElement getPassword() { return password; }
    public WebElement getButton() { return button; }
}
