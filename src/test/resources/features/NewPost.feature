Feature: New post
  This feature verifies the functionality of adding new post on wordpress

  Background: User is logged on with valid username and password
    Given user navigates to Login page
    When user logs in with 'testfurautomation@gmail.com' username and 'LearningTesting123' password
    Then user is redirected to HomePage

  Scenario: Add a new post
    When user clicks on Posts
    And user clicks on Add new
    And user enters title
    And user saves post
    Then new post is publish

