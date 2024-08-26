package functionalinterfaces;

import java.util.List;
import java.util.function.Supplier;

public class Suppliers {

    public static void main(String[] args) {
        // normal java method call
        System.out.println(
                getDbName()
        );
        // functional call
        System.out.println(supplier.get());
        System.out.println(supplierDbList.get());
    }

    static String getDbName(){
        return "employees";
    }

    static Supplier<String> supplier = () -> "employees";

    static Supplier<List<String>> supplierDbList = () ->
            List.of("employees", "remoteStaff");
}
