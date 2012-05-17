package luhn.validator.support;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import luhn.validator.support.StringSpaceRemover;

import org.junit.Test;

public class StringSpaceRemoverSpecificationTest {
	@Test 
	public void removesSpacesFromAString(){
		assertEquals("ABC123", StringSpaceRemover.removeSpaces(" ABC 123 "));
	}
	@Test 
	public void doesntRemoveCharactersAndDigitsFromAString(){
		assertEquals("ABC123", StringSpaceRemover.removeSpaces("ABC123"));
	}
}
