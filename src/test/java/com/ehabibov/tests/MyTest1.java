package com.ehabibov.tests;

import org.testng.annotations.Test;

import com.ehabibov.pageobjects.MainPage;
import com.ehabibov.pageobjects.StartPage;

public class MyTest1 extends AbstractTest {

    @Test
    public void scenario(){
        StartPage startPage = new StartPage();
        MainPage mainPage = startPage.gotoMainPage();
        mainPage.openWidgetMenu();
    }
}
