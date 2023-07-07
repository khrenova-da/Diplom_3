package org.example.page;

import org.example.dto.CreateUserRequest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends BasePage {

    public static final By NAME_FORM_FIELD = By.xpath("//form/fieldset[1]/div/div/input[@name='name']");
    public static final By EMAIL_FORM_FIELD = By.xpath("//form/fieldset[2]/div/div/input[@name='name']");
    public static final By PASSWORD_FORM_FIELD = By.xpath("//form/fieldset[3]/div/div/input[@name='Пароль']");
    public static final By REGISTER_BUTTON = By.xpath("//div/form/button[contains(text(), 'Зарегистрироваться')]");
    public static final By INVALID_CREDENTIAL_ELEMENT = By.xpath("//main/div/form/fieldset[3]/div/p");
    public static final By LOGIN_BUTTON = By.xpath("//div/main/div/div/p/a[@href='/login']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }


    public void setCredentialsToRegisterForm(CreateUserRequest createUserRequest) {
        WebElement nameField = driver.findElement(NAME_FORM_FIELD);
        WebElement emailField = driver.findElement(EMAIL_FORM_FIELD);
        WebElement passwordField = driver.findElement(PASSWORD_FORM_FIELD);

        nameField.sendKeys(createUserRequest.getName());
        emailField.sendKeys(createUserRequest.getEmail());
        passwordField.sendKeys(createUserRequest.getPassword());
    }


    public void clickRegisterButton() {
        WebElement registerButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(REGISTER_BUTTON));
        registerButton.click();
    }


    public WebElement getInvalidCredentialsElement() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(INVALID_CREDENTIAL_ELEMENT));
    }


    public void clickLoginButton() {
        WebElement loginButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        loginButton.click();
    }
}
