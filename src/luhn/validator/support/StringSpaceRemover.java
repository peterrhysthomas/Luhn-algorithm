package luhn.validator.support;

public class StringSpaceRemover {
	public static String removeSpaces(String input) {
		return input.replaceAll(" ", "");
	}
}
