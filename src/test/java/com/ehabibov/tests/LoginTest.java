package com.ehabibov.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

import com.ehabibov.listeners.test.SeleniumSuiteListener;
import com.ehabibov.listeners.test.SeleniumTestListener;
import com.ehabibov.pageobjects.HomePage;
import com.ehabibov.pageobjects.LoginPage;

@Listeners({SeleniumSuiteListener.class, SeleniumTestListener.class})
public class LoginTest {

    @Test
    @Description("Login into CRM ")
    @Parameters({"username", "password"})
    public void loginTest(String login, String password){
        HomePage homePage = new LoginPage().login(login,password);
    }

    @Test
    @Description("Create account")
    @Parameters({"username", "password"})
    public void createAccount(String login, String password){
        HomePage homePage = new LoginPage().login(login,password);
    }
}
