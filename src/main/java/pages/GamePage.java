package pages;

import org.openqa.selenium.WebDriver;

public class GamePage extends BasePage{

    public GamePage(WebDriver driver) {super(driver);}

    public boolean checkTeamsAndScoreOnGamePage(String teamOne, String teamTwo, String scoreLeft, String scoreRight) {
        return checkTeamsAndScore(teamOne, teamTwo, scoreLeft,scoreRight);
    }
}
