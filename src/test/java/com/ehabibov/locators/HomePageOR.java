package com.ehabibov.locators;

import org.openqa.selenium.By;

public class HomePageOR implements LocatorRepository {

    private static By trait = By.id("welcome");

    public static By getTrait(){
        return trait;
    }
}
