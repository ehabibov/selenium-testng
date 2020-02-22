package com.ehabibov.pageobjects;

import org.openqa.selenium.support.ui.Select;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.ehabibov.locators.AddUserPageOR;

public class AddUserPage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(AddUserPage.class);
    private AddUserPageOR objectRepository;

    public AddUserPage() {
        objectRepository = this.setObjectRepository(AddUserPageOR.class);
        initLocators(objectRepository);
        waitForTrait(objectRepository);
    }

    public SystemUsersPage registerUser(String userRole, String employeeName, String userName,
                                        String status, String password, String confirmPassword){
        Select userRoleSelector = new Select(objectRepository.getUserRoleDropdown());
        userRoleSelector.selectByVisibleText(userRole);
        objectRepository.getEmployeeNameField().sendKeys(employeeName);
        objectRepository.getUserNameField().sendKeys(userName);
        Select statusSelector = new Select(objectRepository.getStatusDropdown());
        statusSelector.selectByVisibleText(status);
        objectRepository.getPasswordField().sendKeys(password);
        objectRepository.getConfirmPasswordField().sendKeys(confirmPassword);
        objectRepository.getSaveUserButton().click();
        return new SystemUsersPage();
    }
}