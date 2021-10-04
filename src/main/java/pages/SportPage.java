package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SportPage extends BasePage{

    @FindBy(xpath = "//li[@class='sp-c-sport-navigation__item ']/a[@data-stat-title='Football']")
    private WebElement footballLink;

    @FindBy(xpath = "//a[@data-stat-title='Scores & Fixtures']")
    private WebElement scoreLink;

    @FindBy(xpath = "//input[@placeholder='Enter a team or competition']")
    private WebElement searchField;

    @FindBy(xpath = "//a[@class='sp-c-search__result-item']")
    private WebElement popUpSearchResultElement;

    @FindBy(xpath = "//a[@class='sp-c-date-picker-timeline__item-inner  false']")
    private List<WebElement> listOfElementsWithYearAndMonths;

    @FindBy(xpath = "//li[@class='gs-o-list-ui__item gs-u-pb-']")
    private List<WebElement> listOfGameElements;

    @FindBy(xpath = "//li[@class='gs-o-list-ui__item gs-u-pb-']")
    private WebElement baseElement;

    public SportPage(WebDriver driver) {super(driver);}

    public void clickOnFootballLink(){
        waitVisibilityOfElement(3, footballLink).click();
    }

    public void clickOnScoreLink(){
        waitVisibilityOfElement(3, scoreLink).click();
    }

    public void enterChampionshipInSearchField(String championship) {
        waitVisibilityOfElement(3, searchField).sendKeys(championship);
        waitElementToBeClickable(3, popUpSearchResultElement).click();
    }

    public void chooseYearMonth(String year, String month) {
        waitForPageLoadComplete(5);
        String xpath = "//span[text()='" + month + "']/following-sibling::span[text()='" + year + "']";
        driver.findElement(By.xpath(xpath)).click();
    }

    public boolean checkTeamsAndScoreOnSportPage(String teamOne, String teamTwo, String scoreLeft, String scoreRight) {
        waitVisibilityOfElement(3, baseElement);
        return checkTeamsAndScore(teamOne, teamTwo, scoreLeft,scoreRight);
    }

    public void clickOnGameField(String teamOne, String teamTwo) {
        String xpathOfElementWithTwoTeams = "//span[text()='" + teamOne + "']/ancestor::div" +
                "[@class='sp-c-fixture__wrapper']/descendant::span[text()='" + teamTwo + "']";
        waitVisibilityOfElement(3, baseElement);
        driver.findElement(By.xpath(xpathOfElementWithTwoTeams)).click();
    }
}
