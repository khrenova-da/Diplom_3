package org.example;

import io.qameta.allure.junit4.DisplayName;
import org.example.dto.CreateUserRequest;
import org.example.page.LoginPage;
import org.example.page.MainPage;
import org.example.page.MyAccountPage;
import org.example.provider.UserProvider;
import org.junit.Assert;
import org.junit.Test;

public class MyAccountPageTest extends BaseTest {

    @Test
    @DisplayName("Go to my account page")
    public void goToMyAccountPageTest() {
        CreateUserRequest randomUserWithValidCredentials = UserProvider.getRandomUserWithValidCredentials();
        accessToken = userClient.register(randomUserWithValidCredentials).extract().jsonPath().get("accessToken");
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickLoginInAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setCredentialsToSignInForm(randomUserWithValidCredentials);
        loginPage.clickSingInButton();
        mainPage.clickMyAccountButton();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        String profileText = myAccountPage.getProfileLabel().getText();
        Assert.assertEquals("Профиль", profileText);
    }

    @Test
    @DisplayName("Go to constructor page")
    public void goToConstructorPageTest() {
        CreateUserRequest randomUserWithValidCredentials = UserProvider.getRandomUserWithValidCredentials();
        accessToken = userClient.register(randomUserWithValidCredentials).extract().jsonPath().get("accessToken");
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickLoginInAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setCredentialsToSignInForm(randomUserWithValidCredentials);
        loginPage.clickSingInButton();
        mainPage.clickMyAccountButton();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickConstructorButton();
        String mainPageLabelText = mainPage.getMainPageLabel().getText();
        Assert.assertEquals("Соберите бургер", mainPageLabelText);
    }

    @Test
    @DisplayName("Go to constructor page by click logo")
    public void goToConstructorPageByClickLogoTest() {
        CreateUserRequest randomUserWithValidCredentials = UserProvider.getRandomUserWithValidCredentials();
        accessToken = userClient.register(randomUserWithValidCredentials).extract().jsonPath().get("accessToken");
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickLoginInAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setCredentialsToSignInForm(randomUserWithValidCredentials);
        loginPage.clickSingInButton();
        mainPage.clickMyAccountButton();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickLogoButton();
        String mainPageLabelText = mainPage.getMainPageLabel().getText();
        Assert.assertEquals("Соберите бургер", mainPageLabelText);
    }

    @Test
    @DisplayName("Successful logout")
    public void successfulLogoutTest() {
        CreateUserRequest randomUserWithValidCredentials = UserProvider.getRandomUserWithValidCredentials();
        accessToken = userClient.register(randomUserWithValidCredentials).extract().jsonPath().get("accessToken");
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickLoginInAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setCredentialsToSignInForm(randomUserWithValidCredentials);
        loginPage.clickSingInButton();
        mainPage.clickMyAccountButton();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickSignOutButton();
        String loginPageLabel = loginPage.getLoginPageLabel().getText();
        Assert.assertEquals("Вход", loginPageLabel);
    }
}
