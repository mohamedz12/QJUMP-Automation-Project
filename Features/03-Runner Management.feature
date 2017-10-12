Feature: Runner Management
  Description: Check adding,editing,deleting and searching for runner
  
  Background: 
  * Open the browser
  * User navigates to 'http://testapps.in/qjump/admin/'

@Add_Runner
Scenario: Check adding runner as well
* User enters username
* User enters correct password
* User clicks Login button
* User clicks 'Runner Management'
* User clicks 'Add Runner'
* user adds a runner
* User clicks Submit
* Runner will be added successfully
* Close the browser

@Edit_Runner
Scenario: Check editing runner as well
* User enters username
* User enters correct password
* User clicks Login button
* User clicks 'Runner Management'
* User clicks 'All Runner'
* User clicks Edit for a runner
* User clicks Submit
* Runner will be edited successfully
* Close the browser

@Search_Runner
Scenario: Check searching for runner as well
* User enters username
* User enters correct password
* User clicks Login button
* User clicks 'Runner Management'
* User clicks 'All Runner'
* User searches for the added runner
* The system will get the result as well for runner
* Close the browser

@Delete_Runner
Scenario: Check deleting runner as well
* User enters username
* User enters correct password
* User clicks Login button
* User clicks 'Runner Management'
* User clicks 'All Runner'
* User clicks Delete for a runner
* Runner will be deleted successfully
* Close the browser
