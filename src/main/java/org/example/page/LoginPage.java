package org.example.page;

import org.example.dto.CreateUserRequest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    public static final By REGISTER_BUTTON = By.xpath("//div/p[1]/a[contains(text(), 'Зарегистрироваться')]");
    public static final By LOGIN_PAGE_LABEL = By.xpath("//div/main/div/h2[contains(text(), 'Вход')]");
    public static final By FORGOT_PASSWORD_BUTTON = By.xpath("//div/p[2]/a[contains(text(), 'Восстановить пароль')]");
    public static final By SIGN_IN_BUTTON = By.xpath("//div/form/button[contains(text(), 'Войти')]");
    public static final By EMAIL_FIELD = By.xpath("//form/fieldset[1]/div/div/input[@name='name']");
    public static final By PASSWORD_FIELD = By.xpath("//form/fieldset[2]/div/div/input[@name='Пароль']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void clickRegisterButton() {
        WebElement registerButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(REGISTER_BUTTON));
        registerButton.click();
    }

    public void clickForgotPasswordButton() {
        WebElement forgotPasswordButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(FORGOT_PASSWORD_BUTTON));
        forgotPasswordButton.click();
    }

    public void clickSingInButton() {
        WebElement signInButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(SIGN_IN_BUTTON));
        signInButton.click();
    }

    public void setCredentialsToSignInForm(CreateUserRequest createUserRequest) {
        WebElement emailField = driver.findElement(EMAIL_FIELD);
        WebElement passwordField = driver.findElement(PASSWORD_FIELD);

        emailField.sendKeys(createUserRequest.getEmail());
        passwordField.sendKeys(createUserRequest.getPassword());
    }

    public WebElement getLoginPageLabel() {
        return new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(LOGIN_PAGE_LABEL));
    }

}
