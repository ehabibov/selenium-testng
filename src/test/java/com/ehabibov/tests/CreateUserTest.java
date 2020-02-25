package com.ehabibov.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

import com.ehabibov.listeners.test.SeleniumSuiteListener;
import com.ehabibov.listeners.test.SeleniumTestListener;
import com.ehabibov.pageobjects.HomePage;
import com.ehabibov.pageobjects.LoginPage;
import com.ehabibov.pageobjects.SystemUsersPage;
import com.ehabibov.pageobjects.AddUserPage;
import com.ehabibov.entities.SystemUser;

import static com.ehabibov.tests.CustomAsserts.*;

@Listeners({SeleniumSuiteListener.class, SeleniumTestListener.class})
public class CreateUserTest {

    @Test
    @Description("Create general user account")
    @Parameters({"username", "password"})
    public void createUserAccount(String login, String password){
        HomePage homePage = new LoginPage().login(login,password);
        SystemUsersPage systemUsersPage = homePage.navigateToSystemUsersPage();
        AddUserPage addUserPage = systemUsersPage.navigateToAddUserPage();
        SystemUser newSystemUser = SystemUser.builder()
                .userName("userLastName").userRole("ESS").employeeName("User Last Name")
                .status("Enabled").password("BRnx<s4a").build();
        systemUsersPage = addUserPage.registerUser(newSystemUser);
        SystemUser registeredUser = systemUsersPage.getUserInfoFromTable(newSystemUser.getUserName());

        assertObjectsEqualIgnoringFields(registeredUser, newSystemUser, SystemUser.Fields.password);
    }
}