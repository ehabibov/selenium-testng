package com.ehabibov.pageobjects;

import com.ehabibov.locators.HomePageOR;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    private HomePageOR objectRepository;

    public HomePage() {
        objectRepository = new HomePageOR();
        initDriver();
        initPage(driver, objectRepository);
    }
}
