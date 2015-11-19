 Feature: Identify valid credit card numbers using the Luhn algorithm
 In order to ensure that the customer is using a correct payment method
 As a website account manager
 I want to ensure the credit card number is valid
 
 Scenario: A valid credit card number can contain no spaces
   Given a credit card number of "5420113841119649"
   When this is validated
   Then the validation succeeds

 Scenario: A valid credit card number can contain spaces
   Given a credit card number of "5420 1138 4111 9649"
   When this is validated
   Then the validation succeeds
 
 Scenario: An invalid credit card number will fail validation
   Given a credit card number of "5420113841119648"
   When this is validated
   Then the validation fails

 Scenario: A credit card number containing alphanumeric characters will fail validation
   Given a credit card number of "542011384111964X"
   When this is validated
   Then the validation fails
 
 Scenario: A blank credit card number will fail validation
   Given a credit card number of ""
   When this is validated
   Then the validation fails