package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).
                        executeScript("return document.readyState").equals("complete"));
    }

    public WebElement waitVisibilityOfElement(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitElementToBeClickable(long timeToWait, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean checkTeamsAndScore(String teamOne, String teamTwo, String scoreLeft, String scoreRight) {
        String xpathOfElementWithTwoTeams = "//span[text()='" + teamOne + "']/ancestor::div" +
                "[@class='sp-c-fixture__wrapper']/descendant::span[text()='" + teamTwo + "']";
        String xpathOfElementWithLeftScore = "// span[text()='" + teamOne + "']/ancestor::div[@class='sp-c-fixture__" +
                "wrapper']/descendant::span[contains(@class,'number--ft') and text()='" + scoreLeft + "']";
        String xpathOfElementWithRightScore = "//span[text()='" + teamOne + "']/ancestor::div[@class='sp-c-fixture__" +
                "wrapper']/descendant::span[text()='" + scoreRight + "']";
        if (driver.findElement(By.xpath(xpathOfElementWithTwoTeams)).isDisplayed())
            if(driver.findElement(By.xpath(xpathOfElementWithLeftScore)).isDisplayed())
                return driver.findElement(By.xpath(xpathOfElementWithRightScore)).isDisplayed();
        return false;
    }
}
