package com.ehabibov.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

import com.ehabibov.listeners.test.SeleniumSuiteListener;
import com.ehabibov.listeners.test.SeleniumTestListener;
import com.ehabibov.pageobjects.DashboardPage;
import com.ehabibov.pageobjects.LoginPage;
import com.ehabibov.pageobjects.SystemUsersPage;
import com.ehabibov.pageobjects.AddUserPage;
import com.ehabibov.entities.SystemUser;

import static com.ehabibov.util.CustomAsserts.*;

@Listeners({SeleniumSuiteListener.class, SeleniumTestListener.class})
public class CreateUserTest {

    @Test
    @Description("Create general user account")
    @Parameters({"username", "password"})
    public void createUserAccount(final String login, final String password) {
        DashboardPage dashboardPage = new LoginPage().login(login, password);
        SystemUsersPage systemUsersPage = dashboardPage.navigateToSystemUsersPage();
        AddUserPage addUserPage = systemUsersPage.navigateToAddUserPage();
        SystemUser newSystemUser = SystemUser.builder()
                .userName("userLastName").userRole("ESS").employeeName("User Last Name")
                .status("Enabled").password("BRnx<s4a").build();
        systemUsersPage = addUserPage.registerUser(newSystemUser);
        SystemUser registeredUser = systemUsersPage.getUserInfoFromTable(newSystemUser.getUserName());

        assertEqualIgnoringFields(registeredUser, newSystemUser, SystemUser.Fields.password);
    }
}