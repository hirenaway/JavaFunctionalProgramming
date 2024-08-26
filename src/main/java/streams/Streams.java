package streams;

import functionalinterfaces.Main;

import java.util.List;
import java.util.stream.Collectors;

import static streams.Streams.Gender.FEMALE;
import static streams.Streams.Gender.MALE;


public class Streams {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Vagabond", MALE),
                new Person("Griffith", FEMALE)
        );

        people.stream()
                .map(person -> person.gender)// used function
                .collect(Collectors.toSet())
                .forEach(System.out::println);// used consumer

        boolean containsFemales = people.stream()
                //.anyMatch(person -> FEMALE.equals(person.gender));// used predicate
                .allMatch(person -> FEMALE.equals(person.gender));// used predicate

        System.out.println(containsFemales);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender){
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
