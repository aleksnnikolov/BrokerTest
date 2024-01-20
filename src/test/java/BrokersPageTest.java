import automation.domain.Broker;
import automation.pages.BrokersHomePage;
import org.example.config.BrowserConfig;
import org.example.config.SeleniumBrowserConfig;
import org.junit.jupiter.api.AfterEach;
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
        brokersPage.clickLoadMore();
        List<Broker> brokerList = brokersPage.getAllBrokers();
    }

    @AfterEach
    public void cleanUp() {
        browserConfig.closeBrowser();
    }
}
