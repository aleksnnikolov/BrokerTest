package org.example.config;

import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static java.lang.Integer.parseInt;

public class SeleniumBrowserConfig implements BrowserConfig {

    private final WebDriver driver;

    public SeleniumBrowserConfig(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void openBrowser() {
        int implicitWaitTime = parseInt(AutomationProperties.getInstance().getProperty(AutomationProperties.IMPLICIT_WAIT_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.of(implicitWaitTime, ChronoUnit.MILLIS));
    }

    @Override
    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    @Override
    public void closeBrowser() {
        driver.close();
    }
}