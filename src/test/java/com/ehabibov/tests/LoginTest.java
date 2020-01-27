package com.ehabibov.tests;

import com.ehabibov.pageobjects.HomePage;
import com.ehabibov.pageobjects.InitPage;
import com.ehabibov.pageobjects.LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

public class LoginTest extends AbstractTest {

    @Test
    @Description("Login into CRM ")
    @Parameters({"username", "password"})
    public void loginTest(String login, String password){
        InitPage initPage = new InitPage();
        LoginPage loginPage = initPage.goToLoginPage();
        HomePage homePage = loginPage.login(login,password);
    }
}
