package com.ehabibov.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import io.qameta.allure.Step;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.List;

import com.ehabibov.locators.SystemUsersPageOR;
import com.ehabibov.entities.SystemUser;

public class SystemUsersPage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(SystemUsersPage.class);
    private SystemUsersPageOR objectRepository;

    public SystemUsersPage() {
        objectRepository = this.setObjectRepository(SystemUsersPageOR.class);
        initLocators(objectRepository);
        waitForTrait(objectRepository);
    }

    @Step("Navigate to \"Add user\" page")
    public AddUserPage navigateToAddUserPage(){
        objectRepository.getAddUserButton().click();
        return new AddUserPage();
    }

    @Step("Search user: {userName}")
    public void searchUserByUserName(String userName){
        objectRepository.getSearchUserField().sendKeys(userName);
        objectRepository.getSearchUserButton().click();
    }

    @Step("Getting user \"{userName}\" information from parsed table")
    public SystemUser getUserInfoFromTable(String userName){
        this.searchUserByUserName(userName);
        List<WebElement> userInfo = objectRepository.getUsersTable().findElements(By.tagName("td"));
        SystemUser user = SystemUser.builder()
                .userName(userInfo.get(1).getText())
                .userRole(userInfo.get(2).getText())
                .employeeName(userInfo.get(3).getText())
                .status(userInfo.get(4).getText()).build();
        return user;
    }

}