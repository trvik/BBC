Feature: Search functionality
  As a user
  I want to test search function on https://www.bbc.com/

  Background:
    Given Home page is opened
      | https://www.bbc.com/ |
    And News button is clicked

  Scenario: Check the title of the searched article
    When User enters the category of the headline article as the searched word
    Then User checks the title of the first found article is equal to expected title
      | Africa Eye: Africa Eye: Retirement Hell |
