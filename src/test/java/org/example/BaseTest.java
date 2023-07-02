package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.client.UserClient;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@Getter
@Setter
public class BaseTest {

    public final UserClient userClient = new UserClient();
    public String accessToken;
    public WebDriver driver;

    @Before
    public void setDriver() {
        String browser = "chrome";
        switch (browser) {
            case "chrome": {
                driver = new ChromeDriver();
                break;
            }
            case "yandex": {
                System.setProperty("webdriver.chrome.driver", "/Users/darkhrenova/Downloads/chromedriver_mac64 (1)/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
                driver = new ChromeDriver(chromeOptions);
            }

        }
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            userClient.delete(accessToken)
                    .statusCode(202)
                    .body("success", Matchers.equalTo(true));
        }
        driver.quit();
    }
}
