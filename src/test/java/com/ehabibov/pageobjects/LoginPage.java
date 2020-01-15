package com.ehabibov.pageobjects;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.ehabibov.locators.LoginPageOR;

public class LoginPage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);

    private LoginPageOR objectRepository;

    public LoginPage() {
        objectRepository = this.setObjectRepository(LoginPageOR.class);
        initPage(objectRepository);
    }

    public HomePage login(String username, String password){
        if (isNotSafari()){
            this.loginForAll(username,password);
        } else {
            this.loginForSafari(username, password);
        }
        return new HomePage();
    }

    private void loginForSafari(String username, String password){
        driver.executeScript("document.querySelector(\"input[type='text']\").click()");
        objectRepository.getUsername().sendKeys(username);
        driver.executeScript("document.querySelector(\"input[type='password']\").click()");
        objectRepository.getPassword().sendKeys(password);
        driver.executeScript("document.querySelector(\"input[type='submit']\").click()");
    }

    private void loginForAll(String username, String password){
        objectRepository.getUsername().click();
        objectRepository.getUsername().sendKeys(username);
        objectRepository.getPassword().click();
        objectRepository.getPassword().sendKeys(password);
        objectRepository.getButton().click();
    }
}
