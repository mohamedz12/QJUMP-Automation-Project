Feature: Product Management
  Description: Check adding,editing,deleting and searching for a product
  
  Background: 
  * Open the browser
  * User navigates to 'http://testapps.in/qjump/restaurant/'
  * User enters username of restaurant
  * User enters correct password
  * User clicks Login button
  * User clicks 'Product Management'

@Add_Product
Scenario: Check adding product as well
* User clicks 'Add product'
* user adds a product
* User clicks Submit
* Product will be added successfully
* Close the browser

@Edit_Product
Scenario: Check editing product as well
* User clicks 'All product'
* User clicks Edit for a product
* User clicks Submit
* Product will be edited successfully
* Close the browser

@Search_Product
Scenario: Check searching for product as well
* User clicks 'All product'
* User searches for the added product
* The system will get the result as well for product
* Close the browser

@Delete_Product
Scenario: Check deleting product as well
* User clicks 'All product'
* User clicks Delete for a product
* Product will be deleted successfully
* Close the browser
