Feature:deals page

Scenario: user files the deals

Given user is logging in
|Bharath3696| crmpro1234567890 |

Then user is on home page hall
And user clicks deals

Then user enter the deal details
| Car customs | AG automotive | Ravanan | 5,00,000 | 98 |


Then close everything