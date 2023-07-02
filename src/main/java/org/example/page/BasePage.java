package org.example.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
@Getter
@Setter
public class BasePage {
    public final WebDriver driver;
}
