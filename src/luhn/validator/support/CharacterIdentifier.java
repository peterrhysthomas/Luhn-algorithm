package luhn.validator.support;

public class CharacterIdentifier {
	public static boolean containsCharacters(String input) {
		for (Character character : input.toCharArray()){
			if(Character.isLetter(character)){
				return true;
			}
		}
		return false;
	}
}
