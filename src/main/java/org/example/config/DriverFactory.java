package org.example.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver getDriver() {

        String browserType = AutomationProperties.getInstance().getProperty(AutomationProperties.BROWSER_TYPE);

        switch (browserType) {
            case "CHROME":
                return new ChromeDriver();
            case "FIREFOX":
                return new FirefoxDriver();
            case "EDGE":
                return new EdgeDriver();
            default:
                throw new RuntimeException("Browser type [" + browserType +  "] not supported, check application.properties");
        }

    }

}
