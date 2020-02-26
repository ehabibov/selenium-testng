package com.ehabibov.pageobjects;

import io.qameta.allure.Step;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.ehabibov.locators.LoginPageOR;

public class LoginPage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    private LoginPageOR objectRepository;

    public LoginPage() {
        driver.get(getAppUrl());
        objectRepository = this.setObjectRepository(LoginPageOR.class);
        initLocators(objectRepository);
        waitForTrait(objectRepository);
    }

    @Step("Logging in with \"{userName} / {password}\"")
    public DashboardPage login(final String userName, final String password) {
        if (isNotSafari()) {
            return this.loginForAll(userName, password);
        } else {
            return this.loginForSafari(userName, password);
        }
    }

    private DashboardPage loginForSafari(final String username, final String password) {
        driver.executeScript("document.querySelector(\"input[type='text']\").click()");
        objectRepository.getUsername().sendKeys(username);
        driver.executeScript("document.querySelector(\"input[type='password']\").click()");
        objectRepository.getPassword().sendKeys(password);
        driver.executeScript("document.querySelector(\"input[type='submit']\").click()");
        return new DashboardPage();
    }

    private DashboardPage loginForAll(final String username, final String password) {
        objectRepository.getUsername().click();
        objectRepository.getUsername().sendKeys(username);
        objectRepository.getPassword().click();
        objectRepository.getPassword().sendKeys(password);
        objectRepository.getButton().click();
        return new DashboardPage();
    }
}