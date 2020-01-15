package com.ehabibov.pageobjects;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class InitPage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(InitPage.class);

    public LoginPage goToLoginPage(){
        driver.manage().window().maximize();
        driver.get(getAppUrl());
        return new LoginPage();
    }

}
