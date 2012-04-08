package luhntest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class LuhnValidationSpecificationTest {

	LuhnValidation validator;
	
	@Before
	public void setup(){
		validator = new LuhnValidation();
	}
	
	@Test(expected=ValidationFailureException.class)
	public void shouldThrowExceptionWhenNullIsChecked() throws ValidationFailureException{
		validator.checkForIncorrectEntry(null);
		
	}

	@Test(expected=ValidationFailureException.class)
	public void shouldThrowExceptionWhenStringContainingCharactersIsChecked() throws ValidationFailureException{
		validator.checkForIncorrectEntry("123X123");
	}
	
	@Test
	public void shouldNotThrowExceptionWhenNumericsIsChecked() throws ValidationFailureException{
		validator.checkForIncorrectEntry("123");
	}

	@Test
	public void shouldNotThrowExceptionWhenNumericsWithSpacesIsChecked() throws ValidationFailureException{
		validator.checkForIncorrectEntry("123 123");
	}
	
	@Test
	public void shouldNotThrowExceptionForModulo10ResultOfZero() throws ValidationFailureException{
		validator.validateChecksum(10L);
		validator.validateChecksum(0L);
		validator.validateChecksum(20L);
	}
	
	@Test(expected=ValidationFailureException.class)
	public void shouldThrowExceptionForModulo10ResultOfNonZero() throws ValidationFailureException{
		validator.validateChecksum(11L);
	}
	
	@Test
	public void shouldReturnTrueForEverySecondDigitFromTheRightmostWithinString(){
		String testString = "ABCDE";
		assertTrue(validator.characterAtIndexShouldBeDoubled(testString,3));
		assertTrue(validator.characterAtIndexShouldBeDoubled(testString,1));
	}
	
	@Test
	public void shouldReturnFalseForEveryOtherDigitFromTheRightmostWithinString(){
		String testString = "ABCDE";
		assertFalse(validator.characterAtIndexShouldBeDoubled(testString,4));
		assertFalse(validator.characterAtIndexShouldBeDoubled(testString,2));
		assertFalse(validator.characterAtIndexShouldBeDoubled(testString,0));
		
	}
	
	@Test 
	public void shouldCalculateDoubledValueWhereResultIsSingleDigit(){
		assertEquals(2, validator.calculateDoubledValue("1"));
		assertEquals(4, validator.calculateDoubledValue("2"));
		assertEquals(6, validator.calculateDoubledValue("3"));
		assertEquals(8, validator.calculateDoubledValue("4"));
	}
	
	@Test
	public void shouldCalculateDoubledValueAndAddDigitsWhereResultIsTwoDigits(){
		assertEquals(1, validator.calculateDoubledValue("5"));
		assertEquals(3, validator.calculateDoubledValue("6"));
		assertEquals(5, validator.calculateDoubledValue("7"));
		assertEquals(7, validator.calculateDoubledValue("8"));
		assertEquals(9, validator.calculateDoubledValue("9"));
	}
}
