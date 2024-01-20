import automation.domain.Broker;
import automation.pages.BrokersHomePage;
import lombok.extern.log4j.Log4j2;
import org.example.config.AutomationProperties;
import org.example.config.BrowserConfig;
import org.example.config.DriverFactory;
import org.example.config.SeleniumBrowserConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;

@Log4j2
public class BrokersPageTest {

    private WebDriver driver;
    private BrowserConfig browserConfig;

    @BeforeAll
    public static void environmentSetup() {
        AutomationProperties.getInstance();
    }

    @BeforeEach
    public void testSetup() {
        driver = DriverFactory.getDriver();

        browserConfig = new SeleniumBrowserConfig(driver);
        browserConfig.openBrowser();
        browserConfig.navigateTo("https://www.yavlena.com/broker/");

        log.info("");
        log.info("STARTING TEST");
        log.info("");
    }

    @Test
    public void pageShouldFilterBrokers() {
        BrokersHomePage brokersPage = new BrokersHomePage(driver);
        brokersPage.closeCookiesOverlayIfPresent();
        brokersPage.clickLoadMore();
        List<Broker> brokerList = brokersPage.getAllBrokers();
        brokersPage.verifyBrokerFiltering(brokerList);
    }

    @AfterEach
    public void cleanUp() {
        browserConfig.closeBrowser();
    }
}
