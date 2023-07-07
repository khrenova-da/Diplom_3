package org.example;

import io.qameta.allure.junit4.DisplayName;
import org.example.page.MainPage;
import org.junit.Assert;
import org.junit.Test;


public class MainPageTest extends BaseTest {

    @Test
    @DisplayName("Go to sauce tab test")
    public void goToSauceTabTest() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();
        mainPage.clickSauceButton();
        Assert.assertTrue(mainPage.isSauceTabActive());
    }


    @Test
    @DisplayName("Go to filling tab test")
    public void goToFillingTabTest() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();
        mainPage.clickFillingButton();
        Assert.assertTrue(mainPage.isFillingTabActive());
    }

    @Test
    @DisplayName("Go to bun tab test")
    public void goToBunTabTest() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();
        mainPage.clickFillingButton();
        mainPage.clickBunButton();
        Assert.assertTrue(mainPage.isBunTabActive());
    }

}
