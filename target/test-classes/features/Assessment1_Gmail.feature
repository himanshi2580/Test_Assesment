Feature: Automation Assessment 1

  Scenario: Login to gmail and sent a mail
    Given User is on gmail lodin page
    And Enter username and password
    When Click on Login button
    Then User should be logged into gmail account
    When Create a mail
    Then Attach a file and add recipients and subjects
    And Click on send button
    And Verify the message for mail sent