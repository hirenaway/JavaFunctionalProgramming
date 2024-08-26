package optionals;

import java.util.Optional;

public class Optionals {

    public static void main(String[] args) {
        Object value = Optional.ofNullable("Hi").orElseGet(
                () -> "default"
        );
        System.out.println(value);

        value = Optional.ofNullable("Hi").orElseThrow(
                () -> new IllegalStateException("Exception")
        );
        System.out.println(value);

        Optional.ofNullable("Hi").ifPresent(
                (System.out::println)
        );

        Optional.ofNullable("abc@gmail.com").ifPresentOrElse(
                email -> System.out.println("sending email to " + email),
                () -> System.out.println("not found")
        );

    }
}
