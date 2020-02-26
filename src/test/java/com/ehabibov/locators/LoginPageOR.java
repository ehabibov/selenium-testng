package com.ehabibov.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import lombok.Getter;

@Getter
public class LoginPageOR implements LocatorRepository {

    private By trait = By.id("frmLogin");

    @FindBy(id = "txtUsername")     private WebElement username;
    @FindBy(id = "txtPassword")     private WebElement password;
    @FindBy(id = "btnLogin")        private WebElement button;

    public By getTrait() {
        return trait;
    }
}