package org.example;

import io.qameta.allure.junit4.DisplayName;
import org.example.dto.CreateUserRequest;
import org.example.page.ForgotPasswordPage;
import org.example.page.LoginPage;
import org.example.page.MainPage;
import org.example.page.RegisterPage;
import org.example.provider.UserProvider;
import org.junit.Assert;
import org.junit.Test;

public class LoginPageTest extends BaseTest {

    @Test
    @DisplayName("Successful login from main page test")
    public void successfulLoginFromMainPageTest() {
        CreateUserRequest randomUserWithValidCredentials = UserProvider.getRandomUserWithValidCredentials();
        accessToken = userClient.register(randomUserWithValidCredentials).extract().jsonPath().get("accessToken");
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickLoginInAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setCredentialsToSignInForm(randomUserWithValidCredentials);
        loginPage.clickSingInButton();
        String orderButtonText = mainPage.getCreateOrderButton().getText();
        Assert.assertEquals("Оформить заказ", orderButtonText);
    }

    @Test
    @DisplayName("Successful login from my account page test")
    public void successfulLoginFromMyAccountPageTest() {
        CreateUserRequest randomUserWithValidCredentials = UserProvider.getRandomUserWithValidCredentials();
        accessToken = userClient.register(randomUserWithValidCredentials).extract().jsonPath().get("accessToken");
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickMyAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setCredentialsToSignInForm(randomUserWithValidCredentials);
        loginPage.clickSingInButton();
        String orderButtonText = mainPage.getCreateOrderButton().getText();
        Assert.assertEquals("Оформить заказ", orderButtonText);
    }

    @Test
    @DisplayName("Successful login from register page test")
    public void successfulLoginFromRegisterPageTest() {
        CreateUserRequest randomUserWithValidCredentials = UserProvider.getRandomUserWithValidCredentials();
        accessToken = userClient.register(randomUserWithValidCredentials).extract().jsonPath().get("accessToken");
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickLoginInAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterButton();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickLoginButton();
        loginPage.setCredentialsToSignInForm(randomUserWithValidCredentials);
        loginPage.clickSingInButton();
        String orderButtonText = mainPage.getCreateOrderButton().getText();
        Assert.assertEquals("Оформить заказ", orderButtonText);
    }

    @Test
    @DisplayName("Successful login from forgot password page test")
    public void successfulLoginFromForgotPasswordPageTest() {
        CreateUserRequest randomUserWithValidCredentials = UserProvider.getRandomUserWithValidCredentials();
        accessToken = userClient.register(randomUserWithValidCredentials).extract().jsonPath().get("accessToken");
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickLoginInAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPasswordButton();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickLoginButton();
        loginPage.setCredentialsToSignInForm(randomUserWithValidCredentials);
        loginPage.clickSingInButton();
        String orderButtonText = mainPage.getCreateOrderButton().getText();
        Assert.assertEquals("Оформить заказ", orderButtonText);
    }
}
