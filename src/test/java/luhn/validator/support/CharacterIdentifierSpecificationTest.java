package luhn.validator.support;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import luhn.validator.support.CharacterIdentifier;

import org.junit.Test;

public class CharacterIdentifierSpecificationTest {
	@Test
	public void returnsFalseForNumericString(){
		assertFalse(CharacterIdentifier.containsCharacters("123"));
	}

	@Test
	public void returnsFalseForNumericStringContainingSpaces(){
		assertFalse(CharacterIdentifier.containsCharacters("123 123"));
	}
	
	@Test
	public void returnsTrueForCharacterString(){
		assertTrue(CharacterIdentifier.containsCharacters("A"));		
	}
}
