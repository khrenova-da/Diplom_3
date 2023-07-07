package org.example;

import io.qameta.allure.junit4.DisplayName;
import org.example.dto.CreateUserRequest;
import org.example.dto.LoginUserRequest;
import org.example.page.LoginPage;
import org.example.page.MainPage;
import org.example.page.RegisterPage;
import org.example.provider.UserProvider;
import org.junit.Assert;
import org.junit.Test;

public class RegisterPageTest extends BaseTest {

    @Test
    @DisplayName("Successful register with valid credentials")
    public void successfulRegisterWithValidCredentialsTest() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();
        mainPage.clickLoginInAccount();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickRegisterButton();
        RegisterPage registerPage = new RegisterPage(getDriver());
        CreateUserRequest randomAccountWithValidCredentials = UserProvider.getRandomUserWithValidCredentials();
        registerPage.setCredentialsToRegisterForm(randomAccountWithValidCredentials);
        registerPage.clickRegisterButton();
        String loginPageLabel = loginPage.getLoginPageLabel().getText();
        LoginUserRequest loginUserRequest = LoginUserRequest.from(randomAccountWithValidCredentials);
        accessToken = userClient.login(loginUserRequest).extract().jsonPath().get("accessToken");
        Assert.assertEquals("Вход", loginPageLabel);
    }

    @Test
    @DisplayName("Failed register with short password")
    public void failedRegisterWithShortPasswordTest() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();
        mainPage.clickLoginInAccount();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickRegisterButton();
        RegisterPage registerPage = new RegisterPage(getDriver());
        CreateUserRequest randomAccountWithValidCredentials = UserProvider.getRandomUserWithInvalidCredentials();
        registerPage.setCredentialsToRegisterForm(randomAccountWithValidCredentials);
        registerPage.clickRegisterButton();
        String invalidCredentialsElementText = registerPage.getInvalidCredentialsElement().getText();
        LoginUserRequest loginUserRequest = LoginUserRequest.from(randomAccountWithValidCredentials);
        accessToken = userClient.login(loginUserRequest).extract().jsonPath().get("accessToken");
        Assert.assertEquals("Некорректный пароль", invalidCredentialsElementText);
    }
}
