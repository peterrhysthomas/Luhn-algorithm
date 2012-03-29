package luhntest;

import org.junit.Before;
import org.junit.Test;


public class LuhnValidationAcceptanceTests {
	
	LuhnValidation validator;
	
	@Before
	public void setup(){
		validator = new LuhnValidation();
	}
	
	@Test(expected=ValidationFailureException.class)
	public void shouldFailValidationWhenNullIsValidated() throws ValidationFailureException{
		validator.validate(null);
	}
	
	@Test(expected=ValidationFailureException.class)
	public void shouldFailValidationWhenCreditCardNumberContainingCharactersIsValidated() throws ValidationFailureException{
		validator.validate("1234X1234");
	}
	
	@Test(expected=ValidationFailureException.class)
	public void shouldFailValidationWhenInvalidCreditCardNumberIsValidated() throws ValidationFailureException{
		validator.validate("99927398716");
	}
	
	@Test
	public void shouldPassValidationWhenValidCreditCardNumberWhichHasEvenNumberOfDigitsIsValidated() throws ValidationFailureException{
		//TODO - change this!
		validator.validate("5420113841119649");
	}
	
	@Test
	public void shouldPassValidationWhenValidCreditCardNumberWhichHasOddNumberOfDigitsIsValidated() throws ValidationFailureException{
		validator.validate("49927398716");
	}
	
	@Test
	public void shouldPassValidationWhenValidCreditCardNumberContainingSpacesIsValidated() throws ValidationFailureException{
		validator.validate("4992 7398 716");
	}
}
