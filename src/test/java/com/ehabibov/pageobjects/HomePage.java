package com.ehabibov.pageobjects;

import com.ehabibov.locators.HomePageOR;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class HomePage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);

    private HomePageOR objectRepository;

    public HomePage() {
        objectRepository = this.setObjectRepository(HomePageOR.class);
        initPage(objectRepository);
    }
}
