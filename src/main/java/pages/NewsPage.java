package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NewsPage extends BasePage{

    @FindBy(xpath = "//h3[contains(@class, 'paragon')]")
    private WebElement topArticleTitle;

    @FindBy(xpath = "//div[contains(@class,'top-stories')]/descendant::div[contains(@class,'gs-u-mt@m')]/" +
            "descendant::a[contains(@class,'link-split__anchor')]/h3")
    private List<WebElement> listOfMainArticles;

    @FindBy(xpath = "//div[@aria-label='Top Stories']/descendant::div[contains(@class, " +
            "'nw-o-keyline@s nw-o-no-keyline@m')]/descendant::a[contains(@aria-label, 'From')]/span")
    private WebElement categoryElement;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchInput;

    @FindBy(xpath = "//nav[@class='nw-c-nav__wide']/descendant::span[text()='Coronavirus']")
    private WebElement coronavirusLink;

    @FindBy(xpath = "//span[text()='Contact BBC News']")
    private WebElement contactBBCNewsButton;

    @FindBy(xpath = "//a[text()='send us a story']")
    private WebElement storyButton;

    public NewsPage(WebDriver driver) {super(driver);}

    public String getTitleOfTopArticle() {
        return waitVisibilityOfElement(3,topArticleTitle).getText();}

    public boolean checkAllSecondaryArticlesTitles(List<String> listOfTitles) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(listOfMainArticles));
        int count = 0;
        for (WebElement element:listOfMainArticles) {
            for (String expectedTitle: listOfTitles) {
                String title = element.getText();
                if(expectedTitle.equals(title)) {
                    count++;
                    break;
                }
            }
        }
        return count == listOfMainArticles.size();
    }

    public void enterCategoryOfHeadlineArticle() {
        searchInput.sendKeys(waitVisibilityOfElement(3, categoryElement).getText(), Keys.ENTER);
    }

    public void clickOnCoronavirusLink() {
        waitVisibilityOfElement(3, coronavirusLink).click();
    }

    public void clickOnContactBBCNewsButton() {
        waitVisibilityOfElement(3, contactBBCNewsButton).click();
    }

    public void clickOnSendUsStory() {
        waitVisibilityOfElement(3, storyButton).click();
    }
}
