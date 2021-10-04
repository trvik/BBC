package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {

    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;
    NewsPage newsPage;
    SearchResultPage searchResultPage;
    FormPage formPage;
    SportPage sportPage;
    GamePage gamePage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("Home page is opened")
    public void userOpensHomePage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("News button is clicked")
    public void clickOnNewsButton() {
        homePage.clickNewsButton();
    }

    @Then("User checks the title of the top article")
    public void checkTitleOfTopArticle(String title) {
        newsPage = pageFactoryManager.getNewsPage();
        assertEquals(title, newsPage.getTitleOfTopArticle());
    }

    @Then("User checks the titles of the main articles")
    public void checkTitlesOfMainArticles(List<String> listOfTitles) {
        newsPage = pageFactoryManager.getNewsPage();
        assertTrue(newsPage.checkAllSecondaryArticlesTitles(listOfTitles));
    }

    @When("User enters the category of the headline article as the searched word")
    public void enterCategoryOfHeadlineArticleAsSearchedWord() {
        newsPage = pageFactoryManager.getNewsPage();
        newsPage.enterCategoryOfHeadlineArticle();
    }

    @Then("User checks the title of the first found article is equal to expected title")
    public void checkTitleOfFirstSearchedArticle(String title) {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        assertEquals(title, searchResultPage.getTitleOfFirstArticle());
    }

    @Given("Coronavirus link is clicked")
    public void clickOnCoronavirusLink() {
        newsPage = pageFactoryManager.getNewsPage();
        newsPage.clickOnCoronavirusLink();
    }

    @And("Contact BBC News button is clicked")
    public void clickOnContactBBCNewsButton() {
        newsPage.clickOnContactBBCNewsButton();
    }

    @And("Send us story button is clicked")
    public void clickOnSendUsStoryButton() {
        newsPage.clickOnSendUsStory();
    }

    @When("User fills in incorrect data into required fields {string} {string} {string}")
    public void fillInIncorrectDataIntoRequiredFields(String story, String name, String accept) {
        formPage = pageFactoryManager.getFormPage();
        formPage.fillInForm(story, name, accept);
    }

    @And("User clicks on submit button")
    public void clickOnSubmitButton() {formPage.clickOnSubmitButton();}

    @Then("User checks displaying three messages about mistakes {string}")
    public void checkDisplayingThreeMessagesAboutMistakes(String acceptRadioButton) {
        assertTrue(formPage.isMistakeMessageDisplayed(acceptRadioButton));
    }

    @Given("Sport button is clicked")
    public void clickOnSportButton() {homePage.clickSportButton();}

    @And("Football link is clicked")
    public void clickOnFootballLink() {
        sportPage = pageFactoryManager.getSportPage();
        sportPage.clickOnFootballLink();
    }

    @And("Score link is clicked")
    public void clickOnScoreLink() {
        sportPage.clickOnScoreLink();
    }

    @When("User enters championship {string}")
    public void enterChampionship(String championship) {
        sportPage.enterChampionshipInSearchField(championship);

    }

    @And("User chooses year {string} and month {string}")
    public void chooseYearAndMonth(String year, String month) {
        sportPage.chooseYearMonth(year, month);
    }

    @Then("User checks on sport page team {string} and team {string} played with the score {string} : {string}")
    public void checkTeamsAndScoreOnSportPage(String teamOne, String teamTwo, String scoreLeft, String scoreRight) {
        assertTrue(sportPage.checkTeamsAndScoreOnSportPage(teamOne, teamTwo, scoreLeft,scoreRight));
    }

    @When("User clicks on field with the team {string} and team {string}")
    public void clickOnGameField(String teamOne, String teamTwo) {
        sportPage.clickOnGameField(teamOne, teamTwo);
    }

    @Then("User checks info on game page team {string} and team {string} played with the score {string} : {string}")
    public void checkInfoOnGamePage(String teamOne, String teamTwo, String scoreLeft, String scoreRight) {
        gamePage = pageFactoryManager.getGamePage();
        assertTrue(gamePage.checkTeamsAndScoreOnGamePage(teamOne, teamTwo, scoreLeft,scoreRight));
    }

    @After
    public void tearDown() {driver.close();}
}
