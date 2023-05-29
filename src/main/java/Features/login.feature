
#******************************************************************************************
#                            DATADRIVEN WITHOUT EXAMPLE KEYWORD 
#******************************************************************************************

#Feature: Free CRM login feature
#
#Scenario: Free CRM login test scenario
#
#Given user is already on Login page
#When title of login page is Free CRM  - CRM software for customer relationship management, sales, and support
#Then user enters "Bharath3696" and "crmpro1234567890"
#And user clicks on login button
#Then user is on home page

#******************************************************************************************
#                                  DATADRIVEN WITH EXAMPLE KEYWORD 
#******************************************************************************************


Feature: Free CRM login feature

@SmokeTest
Scenario Outline: Free CRM login test scenario

#Given user is already on Login page
When title of login page is Free CRM  - CRM software for customer relationship management, sales, and support
Then user enters "<uname>" and "<pdw>"
And user clicks on login button
#Then user is on home page

Examples: 
    |  uname      |   pdw            | 
    |saju3696     | jsdfjdlfjal      |
    |Bharath3696  | crmpro1234567890 |
    
    