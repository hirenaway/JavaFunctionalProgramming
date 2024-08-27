package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import combinatorpattern.CustomerCombinatorValidationService.ValidationResult;

import static combinatorpattern.CustomerCombinatorValidationService.ValidationResult.*;

public interface CustomerCombinatorValidationService extends Function<CustomerModel, ValidationResult> {

    static CustomerCombinatorValidationService isEmailValid(){
        return customer -> customer.getEmail().contains("@") ? SUCCESSFULLY_VALID : INVALID_EMAIL_ID;
    }

    static CustomerCombinatorValidationService isPhoneNumberValid(){
        return customer -> customer.getPhoneNumber().startsWith("+91") && customer.getPhoneNumber().length() == 13 ?
                SUCCESSFULLY_VALID : INVALID_PHONE_NUMBER;
    }

    static CustomerCombinatorValidationService isAdult(){
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() >= 18 ?
                SUCCESSFULLY_VALID : CUSTOMER_IS_NOT_AN_ADULT;
    }

    default CustomerCombinatorValidationService and(CustomerCombinatorValidationService validate){
        return customer -> {
            ValidationResult result= this.apply(customer);
            return result.equals(SUCCESSFULLY_VALID) ? validate.apply(customer) : result;
        };
    }

    enum ValidationResult {
        SUCCESSFULLY_VALID,
        INVALID_EMAIL_ID,
        INVALID_PHONE_NUMBER,
        CUSTOMER_IS_NOT_AN_ADULT
    }
}
