Feature:datadriven with map 

Scenario: user files the multiple deals 

Given user is logging in maps
| Username  | password         |
|Bharath3696| crmpro1234567890 |

Then user is on home page hall maps
And user clicks deals maps

Then user enter the deal details maps
|  Title      | Companye        | Primary_contact           | Amount     | Probability |
| Car customs | AG automotive  | AG Ravanan                | 50,00,000  |     98      |
| Gold        | KGF golds      | Raja Krishanappa veeraiya | 800,00,000 |     100     |
| IT          | Google         | Sundar Ramasamy           | 65,00,000  |     98      |
| Drugs       | Scorpian drugs | Rolex                     | 20,00,000  |     99      |


Then close everything maps