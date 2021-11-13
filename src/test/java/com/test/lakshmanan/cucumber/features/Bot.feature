Feature: My Account

  @Bot
  Scenario Outline: Update Personal Information (First Name) in my account
    Given I launch the <application>
    And I play the treasurehunt
    Examples:
      |application        |
      |treasureHunt |
