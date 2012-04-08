package luhntest;

public class LuhnValidation {

	public void validate(String creditCardNumber) throws ValidationFailureException {
		checkForIncorrectEntry(creditCardNumber);
		long result = evaluateChecksum(creditCardNumber);
		validateChecksum(result);
	}

	public void validateChecksum(long result) throws ValidationFailureException {
		if (result % 10 != 0){
			throw new ValidationFailureException();
		}
	}

	private long evaluateChecksum(String creditCardNumber) {
		long luhnValue = 0;
		creditCardNumber = StringHelper.removeSpaces(creditCardNumber);
		int i = creditCardNumber.length() - 1;
		
		while(i>=0){
			String singleDigit = Character.toString(creditCardNumber.charAt(i));
			if (characterAtIndexShouldBeDoubled(creditCardNumber, i)){
				luhnValue += calculateDoubledValue(singleDigit);
			} else {
				luhnValue += Integer.parseInt(singleDigit);
			}
			i--;
		}
		return luhnValue;
	}

	public int calculateDoubledValue(String input) {
		int value = Integer.parseInt(input);
		int result = value * 2;
		if (result > 9){
			result = 1 + result % 10;
		} 
		return result;
	}

	public boolean characterAtIndexShouldBeDoubled(String creditCardNumber, int index) {
		if ((creditCardNumber.length() - index) % 2 == 1){
			return false;
		}
		return true;
	}

	public void checkForIncorrectEntry(String creditCardNumber) throws ValidationFailureException {
		if (creditCardNumber == null  || StringHelper.containsCharacters(creditCardNumber)){
			throw new ValidationFailureException();
		}
		
	}
}
