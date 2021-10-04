package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id='orb-nav-links']/descendant::a[text()='News']")
    private WebElement newsButton;

    @FindBy(xpath = "//div[@id='orb-nav-links']/descendant::a[text()='Sport']")
    private WebElement sportButton;

    public HomePage(WebDriver driver) {super(driver);}

    public void openHomePage(String url) {driver.get(url);}

    public void clickNewsButton() {waitVisibilityOfElement(3,newsButton).click();}

    public void clickSportButton() {waitVisibilityOfElement(3,sportButton).click();}
}
