package com.ehabibov.pageobjects;

import org.openqa.selenium.interactions.Actions;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.ehabibov.locators.HomePageOR;

public class HomePage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(HomePage.class);
    private HomePageOR objectRepository;

    public HomePage() {
        objectRepository = this.setObjectRepository(HomePageOR.class);
        initLocators(objectRepository);
        waitForTrait(objectRepository);
    }

    public SystemUsersPage navigateToSystemUsersPage(){
        Actions actions = new Actions(driver);
        actions.moveToElement(objectRepository.getAdminModule())
                .moveToElement(objectRepository.getAdminMenuUserManagement())
                .moveToElement(objectRepository.getAdminMenuViewUsers())
                .click();
        actions.perform();
        return new SystemUsersPage();
    }
}