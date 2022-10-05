#Author
#Date
#Descripton
Feature: feature to test login funtionality
@smoketest
  Scenario: check login is successful with valid credentials
    Given user is on login page
    When user enters username and password
    And user click on login button
    Then user is navigated to the home page
