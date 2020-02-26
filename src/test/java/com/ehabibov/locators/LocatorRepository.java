package com.ehabibov.locators;

import org.openqa.selenium.By;
/**
 *  Marker interface to identify WebElement(s) repository for further page initialization by type.
 */
public interface LocatorRepository {
    By getTrait();
}