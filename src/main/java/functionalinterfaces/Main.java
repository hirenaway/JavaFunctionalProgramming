package functionalinterfaces;

import java.util.ArrayList;
import java.util.List;

import static functionalinterfaces.Main.Gender.FEMALE;
import static functionalinterfaces.Main.Gender.MALE;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Vagabond", MALE),
                new Person("Griffith", FEMALE)
        );

        //imperative approach
        System.out.println("//imperative approach");
        List<Person> females = new ArrayList<>();
        for (Person person : people){
            if(FEMALE.equals(person.gender)){
                females.add(person);
            }
        }
        for(Person female : females){
            System.out.println(female);
        }

        //Declarative approach
        System.out.println("//Declarative approach");
        people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .forEach(System.out::println);
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
