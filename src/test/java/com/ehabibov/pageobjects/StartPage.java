package com.ehabibov.pageobjects;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class StartPage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(StartPage.class);

    public MainPage gotoMainPage(){
        driver.manage().window().maximize();
        driver.get("http://www.way2automation.com/demo.html");
        return new MainPage();
    }

}
