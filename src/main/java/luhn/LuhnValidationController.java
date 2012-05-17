package luhn;

import luhn.validator.LuhnValidator;

public class LuhnValidationController {
	
	private LuhnValidator validator = new LuhnValidator();

	public void validate(String creditCardNumber) throws ValidationFailureException {
		validator.checkForIncorrectEntry(creditCardNumber);
		long result = validator.evaluateChecksum(creditCardNumber);
		validator.validateChecksum(result);
	}

}
