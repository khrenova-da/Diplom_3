package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage extends BasePage {
    public static final By PROFILE_LABEL = By.xpath("//main/div/nav/ul/li/a[@href='/account/profile']");
    public static final By CONSTRUCTOR_BUTTON = By.xpath("//header/nav/ul/li[1]/a/p[contains(text(), 'Конструктор')]");
    public static final By LOGO_BUTTON = By.xpath("//div/header/nav/div/a");
    public static final By SIGN_OUT_BUTTON = By.xpath("//main/div/nav/ul/li[3]/button[contains(text(), 'Выход')]");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getProfileLabel() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(PROFILE_LABEL));
    }

    public void clickConstructorButton() {
        WebElement constructorButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(CONSTRUCTOR_BUTTON));
        constructorButton.click();
    }

    public void clickLogoButton() {
        WebElement logoButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(LOGO_BUTTON));
        logoButton.click();
    }

    public void clickSignOutButton() {
        WebElement signOutButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(SIGN_OUT_BUTTON));
        signOutButton.click();
    }
}
