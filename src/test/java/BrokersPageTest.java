import automation.pages.BrokersHomePage;
import org.example.config.BrowserConfig;
import org.example.config.SeleniumBrowserConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BrokersPageTest {

    private WebDriver driver;
    private BrowserConfig browserConfig;

    @BeforeEach
    public void testSetup() {
        driver = new ChromeDriver();

        browserConfig = new SeleniumBrowserConfig(driver);
        browserConfig.openBrowser();
        browserConfig.navigateTo("https://www.yavlena.com/broker/");
    }

    @Test
    public void pageShouldFilterBrokers() {
        BrokersHomePage brokersPage = new BrokersHomePage(driver);
        brokersPage.closeCookiesOverlayIfPresent();
    }

}