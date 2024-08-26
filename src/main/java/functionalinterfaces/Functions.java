package functionalinterfaces;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Functions {

    public static void main(String[] args) {

        //Function takes one argument and produces a result
        int numbFun = incrementFunction.apply(0);
        System.out.println(numbFun);

        int numbMultiply = multiplyFunction.apply(1);
        System.out.println(numbMultiply);

        Function<Integer, Integer> resultFunction =
                incrementFunction.andThen(multiplyFunction);
        System.out.println(resultFunction.apply(9));

        //BiFunction takes two arguments and produces a result

        BiFunction<Integer,Integer,Integer> addAndMultiplyBiFunction =
                (addNumber, multiplyByNumber) -> ++addNumber * multiplyByNumber;
        System.out.println(addAndMultiplyBiFunction.apply(4, 100));
    }

    static Function<Integer, Integer> incrementFunction = number -> ++number;

    static Function<Integer, Integer> multiplyFunction = num -> num * 10;

    static int increment(int number){
        return ++number;
    }

    static int incrementAndMultiply(int number){
        return ++number;
    }

    static int addAndMultiply(int add, int multiplyBy){
        return (++add) * multiplyBy;
    }
}
