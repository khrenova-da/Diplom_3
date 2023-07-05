package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {
    private static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    public static final By ACCOUNT_LOGIN_BUTTON = By.xpath("//main/section[2]/div/button[contains(text(), 'Войти в аккаунт')]");
    public static final By MY_ACCOUNT_BUTTON = By.xpath("//header/nav/a/p[contains(text(), 'Личный Кабинет')]");
    public static final By CREATE_ORDER_BUTTON = By.xpath("//main/section[2]/div/button[contains(text(), 'Оформить заказ')]");
    public static final By MAIN_PAGE_LABEL = By.xpath("//main/section[1]/h1");
    public static final By SAUCE_BUTTON = By.xpath("//main/section[1]/div[1]/div[2]/span[contains(text(), 'Соусы')]");
    public static final By BUN_BUTTON = By.xpath("//main/section[1]/div[1]/div[1]/span[contains(text(), 'Булки')]");
    public static final By FILLING_BUTTON = By.xpath("//main/section[1]/div[1]/div[3]/span[contains(text(), 'Начинки')]");
    public static final By BUN_ACTIVE_TAB = By.xpath(".//section[1]/div[1]/div[1][@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");
    public static final By SAUCE_ACTIVE_TAB = By.xpath(".//section[1]/div[1]/div[2][@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");
    public static final By FILLINGS_ACTIVE_TAB = By.xpath(".//section[1]/div[1]/div[3][@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");



    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(PAGE_URL);
    }

    public void clickLoginInAccount() {
        WebElement accountLoginButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(ACCOUNT_LOGIN_BUTTON));
        accountLoginButton.click();
    }

    public void clickMyAccountButton() {
        WebElement myAccountButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(MY_ACCOUNT_BUTTON));
        myAccountButton.click();
    }

    public WebElement getCreateOrderButton() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(CREATE_ORDER_BUTTON));
    }

    public WebElement getMainPageLabel() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(MAIN_PAGE_LABEL));
    }

    public void clickSauceButton() {
        WebElement sauceButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(SAUCE_BUTTON));
        sauceButton.click();
    }

    public void clickFillingButton() {
        WebElement fillingButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(FILLING_BUTTON));
        fillingButton.click();
    }

    public void clickBunButton() {
        WebElement bunButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(BUN_BUTTON));
        bunButton.click();
    }

    public boolean isSauceTabActive() {
        return driver.findElement(SAUCE_ACTIVE_TAB).isDisplayed();
    }

    public boolean isFillingTabActive() {
        return driver.findElement(FILLINGS_ACTIVE_TAB).isDisplayed();
    }

    public boolean isBunTabActive() {
        return driver.findElement(BUN_ACTIVE_TAB).isDisplayed();
    }

}
