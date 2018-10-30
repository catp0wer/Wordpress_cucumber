Feature: Login and Log out functionality


  Scenario: User is logged on with valid username and password
    Given user navigates to Login page
    When user logs in with 'testfurautomation@gmail.com' username and 'LearningTesting123' password
#    And user clicks the "Continue" button
#    And user fill 'LearningTesting123' password
#    Then user is redirected to ToolBarsPage