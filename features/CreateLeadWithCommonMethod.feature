Feature: Leaftaps Login Functioanlity

@Functional
Scenario: TC001_CreateLead - Positive

When Click on 'CRM/SFA' link
Then 'My Home' page is displayed
When Click on 'Leads' link
Then 'My Leads' page is displayed
When Click on 'Create Lead' link
Then 'Create Lead' page is displayed
Given Enter Company Name as 'CTS'
And Enter First Name as 'Sangeetha'
And Enter Last Name as 'Mathivanan'
When Click on 'smallSubmit' button
Then 'Create Lead' page is displayed