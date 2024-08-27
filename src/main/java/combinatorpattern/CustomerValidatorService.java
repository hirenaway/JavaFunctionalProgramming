package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

    private boolean isEmailValid(String email){
        return email.contains("@");
    }

    private boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("+91") && phoneNumber.length() == 13;
    }

    private boolean isAdult(LocalDate dob){
        return Period.between(dob,LocalDate.now()).getYears() >= 18;
    }

    public  boolean isValid(CustomerModel customerModel){
        return isEmailValid(customerModel.getEmail()) &&
                isPhoneNumberValid(customerModel.getPhoneNumber()) &&
                isAdult(customerModel.getDob());
    }
}
