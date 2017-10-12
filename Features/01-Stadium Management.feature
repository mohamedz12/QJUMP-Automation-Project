Feature: Stadium Management
  Description: Check adding,editing,deleting and searching for stadium
  
  Background: 
  * Open the browser
  * User navigates to 'http://testapps.in/qjump/admin/'

@Add_Stadium
Scenario: Check adding stadium as well
* User enters username
* User enters correct password
* User clicks Login button
* User clicks 'Stadium Management'
* User clicks 'Add Stadium'
* user adds a stadium
* User clicks Submit
* Stadium will be added successfully
* Close the browser

@Edit_Stadium
Scenario: Check editing stadium as well
* User enters username
* User enters correct password
* User clicks Login button
* User clicks 'Stadium Management'
* User clicks 'All Stadium'
* User clicks Edit for a stadium
* User clicks Submit
* Stadium will be edited successfully
* Close the browser

@Search_Stadium
Scenario: Check searching for stadium as well
* User enters username
* User enters correct password
* User clicks Login button
* User clicks 'Stadium Management'
* User clicks 'All Stadium'
* User searches for the added stadium
* The system will get the result as well
* Close the browser

@Delete_Stadium
Scenario: Check deleting stadium as well
* User enters username
* User enters correct password
* User clicks Login button
* User clicks 'Stadium Management'
* User clicks 'All Stadium'
* User clicks Delete for a stadium
* Stadium will be deleted successfully
* Close the browser
