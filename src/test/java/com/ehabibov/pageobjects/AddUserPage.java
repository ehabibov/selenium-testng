package com.ehabibov.pageobjects;

import org.openqa.selenium.support.ui.Select;
import io.qameta.allure.Step;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.ehabibov.locators.AddUserPageOR;
import com.ehabibov.entities.SystemUser;

public class AddUserPage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(AddUserPage.class);
    private AddUserPageOR objectRepository;

    public AddUserPage() {
        objectRepository = this.setObjectRepository(AddUserPageOR.class);
        initLocators(objectRepository);
        waitForTrait(objectRepository);
    }

    @Step("Register new user")
    public SystemUsersPage registerUser(final SystemUser user){
        Select userRoleSelector = new Select(objectRepository.getUserRoleDropdown());
        userRoleSelector.selectByVisibleText(user.getUserRole());
        objectRepository.getEmployeeNameField().sendKeys(user.getEmployeeName());
        objectRepository.getUserNameField().sendKeys(user.getUserName());
        Select statusSelector = new Select(objectRepository.getStatusDropdown());
        statusSelector.selectByVisibleText(user.getStatus());
        objectRepository.getPasswordField().sendKeys(user.getPassword());
        objectRepository.getConfirmPasswordField().sendKeys(user.getPassword());
        objectRepository.getSaveUserButton().click();
        return new SystemUsersPage();
    }
}