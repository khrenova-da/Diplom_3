package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPage extends BasePage {
    private static final By LOGIN_BUTTON = By.xpath("//div/p/a[contains(text(), 'Войти')]");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        WebElement loginButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        loginButton.click();
    }
}
