package com.ehabibov.pageobjects;

import org.openqa.selenium.interactions.Actions;
import io.qameta.allure.Step;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.ehabibov.locators.HomePageOR;

public class DashboardPage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(DashboardPage.class);
    private HomePageOR objectRepository;

    public DashboardPage() {
        objectRepository = this.setObjectRepository(HomePageOR.class);
        initLocators(objectRepository);
        waitForTrait(objectRepository);
    }

    @Step("Navigate to \"System Users\" page")
    public SystemUsersPage navigateToSystemUsersPage() {
        Actions actions = new Actions(driver);
        actions.moveToElement(objectRepository.getAdminModule())
                .moveToElement(objectRepository.getAdminMenuUserManagement())
                .moveToElement(objectRepository.getAdminMenuViewUsers())
                .click();
        actions.perform();
        return new SystemUsersPage();
    }
}