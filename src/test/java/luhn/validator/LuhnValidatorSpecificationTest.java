package luhn.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import luhn.ValidationFailureException;
import luhn.validator.LuhnValidator;

import org.junit.Before;
import org.junit.Test;


public class LuhnValidatorSpecificationTest {

	LuhnValidator validator;
	
	@Before
	public void setup(){
		validator = new LuhnValidator();
	}
	
	@Test(expected=ValidationFailureException.class)
	public void throwsExceptionWhenNullIsChecked() throws ValidationFailureException{
		validator.checkForIncorrectEntry(null);
		
	}

	@Test(expected=ValidationFailureException.class)
	public void throwsExceptionWhenStringContainingCharactersIsChecked() throws ValidationFailureException{
		validator.checkForIncorrectEntry("123X123");
	}
	
	@Test
	public void doesntThrowExceptionWhenNumericsIsChecked() throws ValidationFailureException{
		validator.checkForIncorrectEntry("123");
	}

	@Test
	public void doesntThrowExceptionWhenNumericsWithSpacesIsChecked() throws ValidationFailureException{
		validator.checkForIncorrectEntry("123 123");
	}
	
	@Test
	public void doesntThrowExceptionForModulo10ResultOfZero() throws ValidationFailureException{
		validator.validateChecksum(10L);
		validator.validateChecksum(0L);
		validator.validateChecksum(20L);
	}
	
	@Test(expected=ValidationFailureException.class)
	public void doesntThrowExceptionForModulo10ResultOfNonZero() throws ValidationFailureException{
		validator.validateChecksum(11L);
	}
	
	@Test
	public void returnsTrueForEverySecondDigitFromTheRightmostWithinString(){
		String testString = "ABCDE";
		assertTrue(validator.characterAtIndexShouldBeDoubled(testString,3));
		assertTrue(validator.characterAtIndexShouldBeDoubled(testString,1));
	}
	
	@Test
	public void returnsFalseForEveryOtherDigitFromTheRightmostWithinString(){
		String testString = "ABCDE";
		assertFalse(validator.characterAtIndexShouldBeDoubled(testString,4));
		assertFalse(validator.characterAtIndexShouldBeDoubled(testString,2));
		assertFalse(validator.characterAtIndexShouldBeDoubled(testString,0));
		
	}
	
	@Test 
	public void calculatesDoubledValueWhereResultIsSingleDigit(){
		assertEquals(2, validator.calculateDoubledValue("1"));
		assertEquals(4, validator.calculateDoubledValue("2"));
		assertEquals(6, validator.calculateDoubledValue("3"));
		assertEquals(8, validator.calculateDoubledValue("4"));
	}
	
	@Test
	public void calculatesDoubledValueAndAddDigitsWhereResultIsTwoDigits(){
		assertEquals(1, validator.calculateDoubledValue("5"));
		assertEquals(3, validator.calculateDoubledValue("6"));
		assertEquals(5, validator.calculateDoubledValue("7"));
		assertEquals(7, validator.calculateDoubledValue("8"));
		assertEquals(9, validator.calculateDoubledValue("9"));
	}
}
