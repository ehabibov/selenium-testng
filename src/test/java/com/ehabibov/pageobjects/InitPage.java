package com.ehabibov.pageobjects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InitPage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(InitPage.class);

    public LoginPage goToLoginPage(){
        driver.manage().window().maximize();
        driver.get("http://localhost:8080");
        return new LoginPage();
    }

}
