package com.ehabibov.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import lombok.Getter;

@Getter
public class SystemUsersPageOR implements LocatorRepository {

    private By trait = By.id("systemUser-information");

    @FindBy(id = "btnAdd")                    private WebElement addUserButton;
    @FindBy(id = "searchSystemUser_userName") private WebElement searchUserField;
    @FindBy(id = "searchBtn")                 private WebElement searchUserButton;
    @FindBy(id = "resultTable")               private WebElement usersTable;

    public By getTrait() {
        return trait;
    }
}