package com.ehabibov.tests;

import com.ehabibov.listeners.test.SeleniumSuiteListener;
import com.ehabibov.listeners.test.SeleniumTestListener;
import com.ehabibov.pageobjects.HomePage;
import com.ehabibov.pageobjects.InitPage;
import com.ehabibov.pageobjects.LoginPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

@Listeners({SeleniumSuiteListener.class, SeleniumTestListener.class})
public class LoginTest {

    @Test
    @Description("Login into CRM ")
    @Parameters({"username", "password"})
    public void loginTest(String login, String password){
        InitPage initPage = new InitPage();
        LoginPage loginPage = initPage.goToLoginPage();
        HomePage homePage = loginPage.login(login,password);
    }
}
