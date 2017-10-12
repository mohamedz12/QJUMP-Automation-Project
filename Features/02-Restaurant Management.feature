Feature: Restaurant Management
  Description: Check adding,editing,deleting and searching for restaurant
  
  Background: 
  * Open the browser
  * User navigates to 'http://testapps.in/qjump/admin/'

@Add_Restaurant
Scenario: Check adding restaurant as well
* User enters username
* User enters correct password
* User clicks Login button
* User clicks 'Restaurant Management'
* User clicks 'Add restaurant'
* user adds a restaurant
* User clicks Submit
* Restaurant will be added successfully
* Close the browser

@Edit_Restaurant
Scenario: Check editing restaurant as well
* User enters username
* User enters correct password
* User clicks Login button
* User clicks 'Restaurant Management'
* User clicks 'All restaurant'
* User clicks Edit for a restaurant
* User clicks Submit
* Restaurant will be edited successfully
* Close the browser

@Search_Restaurant
Scenario: Check searching for restaurant as well
* User enters username
* User enters correct password
* User clicks Login button
* User clicks 'Restaurant Management'
* User clicks 'All restaurant'
* User searches for the added restaurant
* The system will get the result as well for restaurant
* Close the browser

@Delete_Restaurant
Scenario: Check deleting restaurant as well
* User enters username
* User enters correct password
* User clicks Login button
* User clicks 'Restaurant Management'
* User clicks 'All restaurant'
* User clicks Delete for a restaurant
* Restaurant will be deleted successfully
* Close the browser
