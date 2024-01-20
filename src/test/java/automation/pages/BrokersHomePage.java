package automation.pages;

import automation.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrokersHomePage extends Page {

    @FindBy(xpath = "//input[contains(@class, 'hide-cookies-message')]")
    private WebElement closeCookiesButton;


    public BrokersHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void closeCookiesOverlayIfPresent() {
        if (closeCookiesButton.isDisplayed()) {
            closeCookiesButton.click();
        }
    }

}
