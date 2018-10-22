Feature: New post
  This feature verifies the functionality of adding new post on wordpress

  Scenario: Check that user is able to add new post
    Given user opens wordpress
    When user clicks on Add
    Then new post is added