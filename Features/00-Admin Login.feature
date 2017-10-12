Feature: Login to QJUMP Admin portal
  Description: Check login with failed and incorrect login credentials
  
  Background: 
  * Open the browser
  * User navigates to 'http://testapps.in/qjump/admin/'

@Failed_Login
Scenario: User logs in with incorrect credentials
* User enters username
* User enters incorrect password
* User clicks Login button
* User will not be logged in as well
* Close the browser


@Successful_Login
Scenario: User logs in with correct credentials
* User enters username
* User enters correct password
* User clicks Login button
* User will be logged in as well
* Close the browser

@Logout
Scenario: User logs out as well
* User enters username
* User enters correct password
* User clicks Login button
* User will be logged in as well
* User logs out
* User will be logged out as well
* Close the browser

@RememberMe
Scenario: Check Remember me working as well
* User enters username
* User enters correct password
* User clicks RememberMe option
* User clicks Login button
* User will be logged in as well
* Close the browser
* Open the browser
* User navigates to 'http://testapps.in/qjump/admin/'
* User will be logged in to DashBoard as well
* Close the browser




