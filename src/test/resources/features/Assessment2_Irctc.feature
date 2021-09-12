Feature: Automation Assessments 2

  Scenario: Search ticket on IRCTC site
    Given User is on IRCTC sites
    And User fills the From and To location
    And Select TATKAL ticket
    And Select Date one month from Today Date
    And Select AC three Tier
    And Select Train with Available Berth
    And Click on Search
