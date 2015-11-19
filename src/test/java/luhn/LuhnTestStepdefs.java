package luhn;


import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.fail;

public class LuhnTestStepdefs {
	
	private LuhnValidationController validator;
	private String creditCardNumber;
	
	@Before
	public void setup(){
		validator = new LuhnValidationController();
	}

	@Then("^the validation succeeds$")
	public void the_validation_succeeds() throws ValidationFailureException {
		validator.validate(creditCardNumber);
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
	
	@When("^I verify a blank credit card number$")
	public void I_verify_a_blank_credit_card_number() {
		creditCardNumber = "";
	}

    @Given("^a credit card number of \"(.*)\"$")
    public void a_credit_card_number_of(String ccNumber) throws Throwable {
        creditCardNumber = ccNumber;
    }

    @When("^this is validated$")
    public void this_is_validated() throws Throwable {
        // do nothing here
    }

}
