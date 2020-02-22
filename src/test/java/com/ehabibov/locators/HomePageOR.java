package com.ehabibov.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class HomePageOR implements LocatorRepository {

    private By trait = By.id("welcome");
    public By getTrait(){ return trait; }

    @FindBy(id = "menu_admin_viewAdminModule")  private WebElement adminModule;
    @FindBy(id = "menu_admin_UserManagement")   private WebElement adminMenuUserManagement;
    @FindBy(id = "menu_admin_viewSystemUsers")  private WebElement adminMenuViewUsers;

    public WebElement getAdminModule() { return adminModule; }
    public WebElement getAdminMenuUserManagement() { return adminMenuUserManagement; }
    public WebElement getAdminMenuViewUsers() { return adminMenuViewUsers; }
}
