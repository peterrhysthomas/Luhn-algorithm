package cucumber;

import luhn.LuhnValidationController;
import luhn.ValidationFailureException;


import cucumber.annotation.Before;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

import static org.junit.Assert.fail;

public class LuhnTestStepdefs {
	
	private LuhnValidationController validator;
	private String creditCardNumber;
	
	@Before
	public void setup(){
		validator = new LuhnValidationController();
	}

	@When("^I verify a valid credit card number not containing spaces$")
	public void I_verify_a_valid_credit_card_number_not_containing_spaces() {
      creditCardNumber = "5420113841119649";
	}

	@Then("^the validation succeeds$")
	public void the_validation_succeeds() throws ValidationFailureException {
		validator.validate(creditCardNumber);
	}

	@When("^I verify a valid credit card number containing spaces$")
	public void I_verify_a_valid_credit_card_number_containing_spaces() {
		creditCardNumber = "5420 1138 4111 9649";
	}

	@When("^I verify a invalid credit card number$")
	public void I_verify_a_invalid_credit_card_number() throws ValidationFailureException {
		creditCardNumber = "99927398716";
	}

	@Then("^the validation fails$")
	public void the_validation_fails() {
		try {
			validator.validate(creditCardNumber);
			fail();
		} catch (ValidationFailureException e) {
			//expected
			//TODO - refactor this with cucumber syntax
		}
	}
	
	@When("^I verify a credit card number containing alphanumeric characters$")
	public void I_verify_a_credit_card_number_containing_alphanumeric_characters() {
		creditCardNumber = "5420 1138X4111A9649";
	}
	
	@When("^I verify a blank credit card number$")
	public void I_verify_a_blank_credit_card_number() {
		creditCardNumber = "";
	}
}
