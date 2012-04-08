-------------------------------------------
The Luhn Credit Card Validation Algorithm - 
-------------------------------------------

The formula verifies a number against its included check-digit, which is usually appended to a partial account number to generate the full account number. This account number must pass the following test:

1.	Counting from the check digit, which is the rightmost, and moving left, double the value of every second digit.
2.	Sum the digits of the products together with the un-doubled digits from the original number.
3.	If the total ends in 0 (put another way, if the total modulo 10 is congruent to 0), then the number is valid according to the Luhn formula; else it is not valid.

As an illustration, if the account number is 49927398716, it will be validated as follows:

1.	Double every second digit, from the rightmost: (1×2) = 2, (8×2) = 16, (3×2) = 6, (2×2) = 4, (9×2) = 18
2.	Sum all digits (digits in parentheses are the products from Step 1): 6 + (2) + 7 + (1 + 6) + 9 + (6) + 7 + (4) + 9 + (1 + 8) + 4 = 70
3.	Take the sum modulo 10: 70 mod 10 = 0; the account number is valid.

-------------------------------------------
Solution Approach
-------------------------------------------

This solution demonstrates the Acceptance and Specification test Unit Testing approach which can be used following an outside-in approach.  The Acceptance and Specification tests have different purposes as follows -

- Acceptance tests prove and document the business functionality and test at the boundary of the solution (the Outside portion of outside-in)
- Specification tests prove and document the technical functionality and test at the API level of the major components of the solution (the Inside portion of outside-in)

These tests are used together as follows - 

1) Write a failing Acceptance test
2) Explore the design to fulfil the Acceptance test
3) For the first portion of the design, write a single failing Specification test
4) Implement the design portion to fulfil the Specification test
5) If the Acceptance test is not passing, repeat from 2), if the Acceptance test is passing then repeat from 1) until all acceptance tests are passing.