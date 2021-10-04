Feature: Contact form functionality
  As a user
  I want to test contact form on https://www.bbc.com/

  Background:
    Given Home page is opened
    |https://www.bbc.com/|
    And News button is clicked

  Scenario Outline: Check the message about mistakes on form page
    Given Coronavirus link is clicked
    And Contact BBC News button is clicked
    And Send us story button is clicked
    When User fills in incorrect data into required fields '<story>' '<name>' '<acceptRadioButton>'
    And User clicks on submit button
    Then User checks displaying three messages about mistakes '<acceptRadioButton>'
    Examples:
      | story  | name   | acceptRadioButton |
      | qwerty | qwerty | no                |
      |        | qwerty | yes               |
      | qwerty |        | yes               |