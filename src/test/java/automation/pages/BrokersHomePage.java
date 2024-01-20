package automation.pages;

import automation.Page;
import automation.domain.Broker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class BrokersHomePage extends Page {

    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @FindBy(xpath = "//input[contains(@class, 'hide-cookies-message')]")
    private WebElement closeCookiesButton;

    @FindBy(xpath = "//a[@data-container='load-more-brokers']")
    private WebElement loadMoreButton;

    @FindBy(xpath = "//input[@id='searchBox' and @data-container='broker-keyword']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[contains(@class, 'clear-all-dropdowns')]")
    private WebElement clearAllButton;


    public BrokersHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void closeCookiesOverlayIfPresent() {
        if (closeCookiesButton.isDisplayed()) {
            closeCookiesButton.click();
        }
    }

    public void clickLoadMore() {
        loadMoreButton.click();
        wait.until(driver -> !loadMoreButton.isDisplayed());
    }

    public List<Broker> getAllBrokers() {
        List<Broker> brokerList = new ArrayList<>();

        List<WebElement> brokerCards = driver.findElements(By.xpath("//article[@class = 'broker-card']"));
        for (WebElement brokerCard : brokerCards) {
            brokerList.add(extractBrokerInfo(brokerCard));
        }

        return brokerList;
    }

    public void verifyBrokerFiltering(List<Broker> brokerList) {
        //TODO: implementation
    }


    private Broker extractBrokerInfo(WebElement brokerCard) {
        String brokerName = brokerCard.findElement(By.className("name")).getText();
        String address = brokerCard.findElement(By.className("office")).getText();
        int numberOfProperties = extractNumberOfProperties(brokerCard);
        List<String> contacts = extractBrokerContacts(brokerCard);

        return new Broker(brokerName, address, numberOfProperties, contacts);
    }

    private int extractNumberOfProperties(WebElement brokerCard) {
        String numberOfPropertiesText = brokerCard.findElement(By.className("position")).findElement(By.tagName("a")).getText();
        return parseInt(numberOfPropertiesText.replaceAll("[^0-9]", ""));
    }

    private List<String> extractBrokerContacts(WebElement brokerCard) {
        return brokerCard
                .findElements(By.className("tel"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
