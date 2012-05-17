package luhn;

import luhn.LuhnValidationController;
import luhn.ValidationFailureException;

import org.junit.Before;
import org.junit.Test;


public class LuhnValidationControllerAcceptanceTests {
	
	LuhnValidationController validator;
	
	@Before
	public void setup(){
		validator = new LuhnValidationController();
	}
	
	@Test(expected=ValidationFailureException.class)
	public void failsValidationWhenNullIsValidated() throws ValidationFailureException{
		validator.validate(null);
	}
	
	@Test(expected=ValidationFailureException.class)
	public void failsValidationWhenCreditCardNumberContainingCharactersIsValidated() throws ValidationFailureException{
		validator.validate("1234X1234");
	}
	
	@Test(expected=ValidationFailureException.class)
	public void failsValidationWhenInvalidCreditCardNumberIsValidated() throws ValidationFailureException{
		validator.validate("99927398716");
	}
	
	@Test
	public void passesValidationWhenValidCreditCardNumberWhichHasEvenNumberOfDigitsIsValidated() throws ValidationFailureException{
		validator.validate("5420113841119649");
	}
	
	@Test
	public void passesValidationWhenValidCreditCardNumberWhichHasOddNumberOfDigitsIsValidated() throws ValidationFailureException{
		validator.validate("49927398716");
	}
	
	@Test
	public void passesValidationWhenValidCreditCardNumberContainingSpacesIsValidated() throws ValidationFailureException{
		validator.validate("4992 7398 716");
	}
}
