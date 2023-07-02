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
        String sauceElementText = mainPage.getSauceLabel().getText();
        Assert.assertEquals("Соусы", sauceElementText);
    }

    @Test
    @DisplayName("Go to filling tab test")
    public void goToFillingTabTest() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();
        mainPage.clickFillingButton();
        String sauceElementText = mainPage.getFillingLabel().getText();
        Assert.assertEquals("Начинки", sauceElementText);
    }

    @Test
    @DisplayName("Go to bun tab test")
    public void goToBunTabTest() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();
        mainPage.clickFillingButton();
        mainPage.clickBunButton();
        String sauceElementText = mainPage.getBunLabel().getText();
        Assert.assertEquals("Булки", sauceElementText);
    }

}
