Feature: Sport page functionality
  As a user
  I want to test sport page on https://www.bbc.com/

  Background:
    Given Home page is opened
      |https://www.bbc.com/|

  Scenario Outline: Check the scores of the games
    Given Sport button is clicked
    And Football link is clicked
    And Score link is clicked
    When User enters championship '<championship>'
    And User chooses year '<year>' and month '<month>'
    Then User checks on sport page team '<teamOne>' and team '<teamTwo>' played with the score '<scoreLeft>' : '<scoreRight>'
    When User clicks on field with the team '<teamOne>' and team '<teamTwo>'
    Then User checks info on game page team '<teamOne>' and team '<teamTwo>' played with the score '<scoreLeft>' : '<scoreRight>'
    Examples:
      | championship          | year | month | teamOne     | teamTwo      | scoreLeft | scoreRight |
      | Scottish Championship | 2021 | AUG   | Dunfermline | Arbroath     | 0         | 3          |
      | Italian Serie A       | 2020 | DEC   | AC Milan    | Lazio        | 3         | 2          |
      | French Ligue 1        | 2021 | SEP   | Troyes      | Angers       | 1         | 1          |
      | Premier League        | 2020 | NOV   | Everton     | Leeds United | 0         | 1          |