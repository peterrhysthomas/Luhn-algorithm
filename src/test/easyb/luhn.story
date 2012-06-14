package luhn

scenario "Verify a valid credit card number not containing spaces",{
    given "a valid credit card number not containing spaces",{
      creditCardNumber = "5420113841119649"

    }
    when "the card number is validated",{
    }
    then "the validation succeeds",{
       validator = new LuhnValidationController()
       validator.validate(creditCardNumber)
    }
}
