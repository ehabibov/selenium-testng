package com.ehabibov.pageobjects;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.ehabibov.locators.SecondaryPageOR;

public class SecondaryPage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(SecondaryPage.class);
    private SecondaryPageOR or;

    public SecondaryPage() {
        or = new SecondaryPageOR();
        initDriver();
        initPage(driver, or);
    }

}
