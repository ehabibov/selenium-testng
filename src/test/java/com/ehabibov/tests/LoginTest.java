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

import static org.testng.Assert.assertEquals;

@Listeners({SeleniumSuiteListener.class, SeleniumTestListener.class})
public class LoginTest {

    @Test
    @Description("Create general user account")
    @Parameters({"username", "password"})
    public void createUserAccount(String login, String password){
        HomePage homePage = new LoginPage().login(login,password);
        SystemUsersPage systemUsersPage = homePage.navigateToSystemUsersPage();
        AddUserPage addUserPage = systemUsersPage.navigateToAddUserPage();
        String userRole = "ESS";
        String employeeName = "User Last Name";
        String userName = "userLastName";
        String status = "Enabled";
        String userPassword = "BRnx<s4a";
        String confirmPassword = "BRnx<s4a";
        systemUsersPage = addUserPage.registerUser(userRole, employeeName, userName, status, userPassword, confirmPassword);
        SystemUsersPage.SystemUser user = systemUsersPage.getUserInfoFromTable(userName);

        assertEquals(user.getUserName(), userName);
        assertEquals(user.getUserRole(), userRole);
        assertEquals(user.getEmployeeName(), employeeName);
        assertEquals(user.getStatus(), status);
    }
}