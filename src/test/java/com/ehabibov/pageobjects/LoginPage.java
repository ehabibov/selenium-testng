package com.ehabibov.pageobjects;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.ehabibov.locators.HomePageOR;
import com.ehabibov.locators.LoginPageOR;

public class LoginPage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);

    private LoginPageOR objectRepository;

    public LoginPage() {
        objectRepository = this.setObjectRepository(LoginPageOR.class);;
        initPage(objectRepository);
    }

    public HomePage login(String username, String password){
        objectRepository.getUsername().click();
        objectRepository.getUsername().sendKeys(username);
        objectRepository.getPassword().click();
        objectRepository.getPassword().sendKeys(password);
        objectRepository.getButton().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(HomePageOR.getTrait()));
        return new HomePage();
    }
}
