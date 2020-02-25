package com.ehabibov.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class SystemUsersPageOR implements LocatorRepository {

    private By trait = By.id("systemUser-information");
    public By getTrait(){ return trait; }

    @FindBy(id = "btnAdd")                    private WebElement addUserButton;
    @FindBy(id = "searchSystemUser_userName") private WebElement searchUserField;
    @FindBy(id = "searchBtn")                 private WebElement searchUserButton;
    @FindBy(id = "resultTable")               private WebElement usersTable;

    public WebElement getAddUserButton() { return addUserButton; }
    public WebElement getSearchUserField() { return searchUserField; }
    public WebElement getSearchUserButton() { return searchUserButton; }
    public WebElement getUsersTable() { return usersTable; }
}