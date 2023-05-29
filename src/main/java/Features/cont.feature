#******************************************************************************************
#                            DATADRIVEN WITHOUT EXAMPLE KEYWORD 
#******************************************************************************************
#Feature: Free CRM contact feature

#Scenario:contact test scenario

#Given user is already on home page
#Then user mouse over to contact and clicks new contact
#Then user create new contact "Sam" "karan"
#Then verifying the created contact exist or not "Sam karan"
#And close the browser

#******************************************************************************************
#                                  DATADRIVEN WITH EXAMPLE KEYWORD 
#******************************************************************************************

Feature: Free CRM contact feature

Scenario Outline:contact test scenario

#Given user is already on home page "<oname>" "<opdw>"
Given user is already on Login page
When title of login page is Free CRM  - CRM software for customer relationship management, sales, and support
Then user enters "<uname>" and "<pdw>"
And user clicks on login button
Then user is on home page
Then user mouse over to contact and clicks new contact
Then user create new contact "<Fgname>" "<lname>"
Then verifying the created contact exist or not "<Fgname>"
And close the browser

Examples: 
    |uname        |pdw              |  Fgname    | lname  |
    |Bharath3696  | crmpro1234567890 |  Sharu     |khan    |
    |  Gopal      |varma             |  Amala     |Shaji   |
    