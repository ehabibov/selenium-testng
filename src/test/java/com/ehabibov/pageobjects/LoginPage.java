package com.ehabibov.pageobjects;

import com.ehabibov.locators.LoginPageOR;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class LoginPage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    private LoginPageOR objectRepository;

    public LoginPage() {
        objectRepository = new LoginPageOR();
        //initDriver();
        initPage(driver, objectRepository);
    }

    public HomePage login(String username, String password){
        objectRepository.getUsername().click();
        objectRepository.getUsername().sendKeys(username);
        objectRepository.getPassword().click();
        objectRepository.getPassword().sendKeys(password);
        objectRepository.getButton().click();
        return new HomePage();
    }
}
