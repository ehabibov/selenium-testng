package com.ehabibov.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class AddUserPageOR implements LocatorRepository {

    private By trait = By.id("UserHeading");
    public By getTrait(){ return trait; }

    @FindBy(id = "systemUser_userType")             private WebElement userRoleDropdown;
    @FindBy(id = "systemUser_employeeName_empName") private WebElement employeeNameField;
    @FindBy(id = "systemUser_userName")             private WebElement userNameField;
    @FindBy(id = "systemUser_status")               private WebElement statusDropdown;
    @FindBy(id = "systemUser_password")             private WebElement passwordField;
    @FindBy(id = "systemUser_confirmPassword")      private WebElement confirmPasswordField;
    @FindBy(id = "btnSave")                         private WebElement saveUserButton;

    public WebElement getUserRoleDropdown() { return userRoleDropdown; }
    public WebElement getEmployeeNameField() { return employeeNameField; }
    public WebElement getUserNameField() { return userNameField; }
    public WebElement getStatusDropdown() { return statusDropdown; }
    public WebElement getPasswordField() { return passwordField; }
    public WebElement getConfirmPasswordField() { return confirmPasswordField; }
    public WebElement getSaveUserButton() { return saveUserButton; }
}