package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {this.driver = driver;}

    public HomePage getHomePage() {return new HomePage(driver);}

    public NewsPage getNewsPage() {return new NewsPage(driver);}

    public SearchResultPage getSearchResultPage() {return new SearchResultPage(driver);}

    public FormPage getFormPage() {return new FormPage(driver);}

    public SportPage getSportPage() {return new SportPage(driver);}

    public GamePage getGamePage() {return new GamePage(driver);}
}
