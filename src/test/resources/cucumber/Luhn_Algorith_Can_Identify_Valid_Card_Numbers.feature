 Feature: Identify valid credit card numbers using the Luhn algorithm
 In order to ensure that the customer is using a valid credit card
 As a website account manager
 I want to ensure the credit card number is valid
 
 Scenario: 
 When I verify a valid credit card number not containing spaces
 Then the validation succeeds
 
 Scenario: 
 When I verify a valid credit card number containing spaces
 Then the validation succeeds