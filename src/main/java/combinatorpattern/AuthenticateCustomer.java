package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerCombinatorValidationService.*;

public class AuthenticateCustomer {

    public static void main(String[] args) {
        CustomerModel model = new CustomerModel(
                "vagabond",
                "vagabond@gmail.com",
                "+916576893547",
                LocalDate.of(2000, 11, 13));

        // if any of the above validation fails we wouldn't be able to identify which one failed by this code
        System.out.println(new CustomerValidatorService().isValid(model));

        // to implement a validation pattern so that we can separate and tell user which validation is failing is important
        // instead of throwing failure altogether we will use combinator pattern that will help us identify which validation is failing

        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult()).apply(model);

        if (result != ValidationResult.SUCCESSFULLY_VALID){
            throw new IllegalStateException(result.name());
        }

        System.out.println(result);
    }
}
