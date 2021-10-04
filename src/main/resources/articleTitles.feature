Feature: Article titles
  As a user
  I want to test correct displaying article titles on https://www.bbc.com/

  Background:
    Given Home page is opened
      | https://www.bbc.com/ |
    And News button is clicked

  Scenario: Check the title of the headline article
    Then User checks the title of the top article
      | Secret assets of Kenyan president’s family exposed |

  Scenario: Check the titles of the main articles
    Then User checks the titles of the main articles
      | How world is reporting leaks on powerful leaders  |
      | Facebook whistleblower reveals identity           |
      | Sense of touch and heat research wins Nobel Prize |
      | Billie Eilish to headline Glastonbury 2022        |
