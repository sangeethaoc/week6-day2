Feature: Leaftaps Login Functioanlity

@Functional
Scenario Outline: TC001_CreateLead - Positive

When Click on 'Leads' link
When Click on 'Find Leads' link
Given First Name as <firstName>
Then Click on 'Find Leads' button
When Click on First Lead displayed
Then Click on Edit button
Given Enter Company Name as <companyName>
When Click on Update Button
Then Verify Company Name is updated

Examples:
|firstName|companyName|
|'Sangeetha'|'CTS'|
|'Varsid'|'HCL'|