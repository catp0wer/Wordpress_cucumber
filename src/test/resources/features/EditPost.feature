Feature: Verification of editing a post

  Background: User is logged on with valid username and password
    Given user navigates to Login page
    When user logs in with 'testfurautomation@gmail.com' username and 'LearningTesting123' password
    Then user is redirected to HomePage
    And user clicks on Posts
    And user clicks on Add new
    And user enters title
    And user saves post
    Then new post is publish
    And user finds and clicks the post in All posts
    Then user is redirected to edit page

  Scenario: Verify that post is updated when title is changed and 'Update' is clicked
    When user updates the title
    And user saves post
    Then title is updated

