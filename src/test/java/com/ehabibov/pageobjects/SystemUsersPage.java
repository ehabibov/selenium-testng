package com.ehabibov.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.List;

import com.ehabibov.locators.SystemUsersPageOR;

public class SystemUsersPage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(SystemUsersPage.class);
    private SystemUsersPageOR objectRepository;

    public SystemUsersPage() {
        objectRepository = this.setObjectRepository(SystemUsersPageOR.class);
        initLocators(objectRepository);
        waitForTrait(objectRepository);
    }

    public AddUserPage navigateToAddUserPage(){
        objectRepository.getAddUserButton().click();
        return new AddUserPage();
    }

    public void searchUserByUserName(String username){
        objectRepository.getSearchUserField().sendKeys(username);
        objectRepository.getSearchUserButton().click();
    }

    public SystemUser getUserInfoFromTable(String username){
        this.searchUserByUserName(username);
        List<WebElement> userInfo = objectRepository.getUsersTable().findElements(By.tagName("td"));
        SystemUser user = new SystemUser();
        user.setUserName(userInfo.get(1).getText());
        user.setUserRole(userInfo.get(2).getText());
        user.setEmployeeName(userInfo.get(3).getText());
        user.setStatus(userInfo.get(4).getText());
        return user;
    }

    public static class SystemUser {
        private String userName;
        private String userRole;
        private String employeeName;
        private String status;

        public String getUserName() { return userName; }
        private void setUserName(String userName) { this.userName = userName; }
        public String getUserRole() { return userRole; }
        private void setUserRole(String userRole) { this.userRole = userRole; }
        public String getEmployeeName() { return employeeName; }
        private void setEmployeeName(String employeeName) { this.employeeName = employeeName; }
        public String getStatus() { return status; }
        private void setStatus(String status) { this.status = status; }
    }
}