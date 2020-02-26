package com.ehabibov.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import lombok.Getter;

@Getter
public class AddUserPageOR implements LocatorRepository {

    private By trait = By.id("UserHeading");

    @FindBy(id = "systemUser_userType")             private WebElement userRoleDropdown;
    @FindBy(id = "systemUser_employeeName_empName") private WebElement employeeNameField;
    @FindBy(id = "systemUser_userName")             private WebElement userNameField;
    @FindBy(id = "systemUser_status")               private WebElement statusDropdown;
    @FindBy(id = "systemUser_password")             private WebElement passwordField;
    @FindBy(id = "systemUser_confirmPassword")      private WebElement confirmPasswordField;
    @FindBy(id = "btnSave")                         private WebElement saveUserButton;

    @Override
    public By getTrait() {
        return trait;
    }
}