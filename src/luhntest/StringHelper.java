package luhntest;

public class StringHelper {

	public static boolean containsCharacters(String input) {
		for (Character character : input.toCharArray()){
			if(Character.isLetter(character)){
				return true;
			}
		}
		return false;
	}

	public static String removeSpaces(String input) {
		return input.replaceAll(" ", "");
	}


}
