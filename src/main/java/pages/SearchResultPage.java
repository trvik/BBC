package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage{

    @FindBy(xpath = "//span[@role='text']/p/span")
    private WebElement titleOfFirstArticle;

    @FindBy(xpath = "//span[@role='text']/p/span")
    List<WebElement> listOfArticleTitles;

    public SearchResultPage(WebDriver driver) {super(driver);}

    public String getTitleOfFirstArticle(){
        String textOfElement = waitVisibilityOfElement(3, titleOfFirstArticle).getText();
        if(textOfElement.contains("weather forecast"))
            textOfElement = listOfArticleTitles.get(1).getText();
        return textOfElement;
    }

}
