package com.ehabibov.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import lombok.Getter;

@Getter
public class HomePageOR implements LocatorRepository {

    private By trait = By.id("welcome");

    @FindBy(id = "menu_admin_viewAdminModule")  private WebElement adminModule;
    @FindBy(id = "menu_admin_UserManagement")   private WebElement adminMenuUserManagement;
    @FindBy(id = "menu_admin_viewSystemUsers")  private WebElement adminMenuViewUsers;

    @Override
    public By getTrait() {
        return trait;
    }
}
