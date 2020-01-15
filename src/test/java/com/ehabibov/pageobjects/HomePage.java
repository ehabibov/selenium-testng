package com.ehabibov.pageobjects;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.time.Duration;

import com.ehabibov.locators.HomePageOR;

public class HomePage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);

    private HomePageOR objectRepository;

    public HomePage() {
        objectRepository = this.setObjectRepository(HomePageOR.class);
        initPage(objectRepository);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(HomePageOR.getTrait()));
    }
}
