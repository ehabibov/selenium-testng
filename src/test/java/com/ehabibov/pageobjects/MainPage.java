package com.ehabibov.pageobjects;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.ehabibov.locators.MainPageOR;

public class MainPage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(MainPage.class);
    private MainPageOR or;

    public MainPage() {
        or = new MainPageOR();
        initDriver();
        initPage(driver, or);
    }

    public void openWidgetMenu(){
        or.getWidget().click();
    }

}