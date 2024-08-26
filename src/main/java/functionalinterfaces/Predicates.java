package functionalinterfaces;

import java.util.function.Predicate;

public class Predicates {
    public static void main(String[] args) {
        // Normal java method call
        System.out.println(isNumberValid("+748867680"));
        System.out.println(isNumberValid("0748867680"));

        // Functional
        System.out.println(isNumberValidPredicate.test("+748867680"));
        System.out.println(isNumberValidPredicate.test("0748867680"));

        System.out.println(isNumberValidPredicate.and(contains5V).test("+748867680"));
        System.out.println(isNumberValidPredicate.or(contains5V).test("+748867680"));
        System.out.println(isNumberValidPredicate.and(contains5V).test("+745867680"));
    }

    static boolean isNumberValid(String number){
        return number.startsWith("+") && number.length() == 10;
    }

    static Predicate<String> isNumberValidPredicate =
            number -> number.startsWith("+") && number.length() == 10;

    static  Predicate<String> contains5V = number ->
            number.contains("5");

}
