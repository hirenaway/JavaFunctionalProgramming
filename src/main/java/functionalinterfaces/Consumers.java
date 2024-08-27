package functionalinterfaces;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Consumers {
    public static void main(String[] args) {
        // normal java method call
        greetCustomer(new Customer("vagabond", "9999999"));

        //Consumer Functional interface
        greetCustomerConsumer.accept(new Customer("vagabond", "9999999"));

        greetCustomerBiConsumer.accept(new Customer("vagabond", "9999999"), Boolean.FALSE);

    }

    static class Customer {
        private final String customerName;
        private final String phoneNumber;

        public Customer(String customerName, String phoneNumber) {
            this.customerName = customerName;
            this.phoneNumber = phoneNumber;
        }
    }

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName +
                " phone number " + customer.phoneNumber +
                " has been activated");
    }

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName +
                    " phone number " + customer.phoneNumber +
                    " has been activated");

    static BiConsumer<Customer, Boolean> greetCustomerBiConsumer = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName +
                    " phone number " + (showPhoneNumber ? customer.phoneNumber : "******") +
                    " has been activated");
}
