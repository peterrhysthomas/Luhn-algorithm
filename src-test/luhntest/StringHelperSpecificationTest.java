package luhntest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

//TODO - Is this really an acceptance test?
public class StringHelperSpecificationTest {
	@Test
	public void containsCharacterShouldReturnFalseForNumericString(){
		assertFalse(StringHelper.containsCharacters("123"));
	}

	@Test
	public void containsCharacterShouldReturnFalseForNumericStringContainingSpaces(){
		assertFalse(StringHelper.containsCharacters("123 123"));
	}
	
	@Test
	public void containsCharacterShouldReturnTrueForCharacterString(){
		assertTrue(StringHelper.containsCharacters("A"));		
	}
	
	@Test 
	public void removeSpacesWillRemoveSpacesFromAString(){
		assertEquals("ABC123", StringHelper.removeSpaces(" ABC 123 "));
	}

}
