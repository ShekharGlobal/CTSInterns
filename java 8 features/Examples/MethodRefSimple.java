package com.hcl.java8;
import java.util.Arrays;

class Utils {
    public static void printStatic(String s) {
        System.out.println("Static: " + s);
    }
}

public class MethodRefSimple {
    public void printInstance(String s) {
        System.out.println("Instance of object: " + s);
    }

    public MethodRefSimple() {
        System.out.println("Constructor called");
    }

    public static void main(String[] args) {
        // 1. Static method reference
        Arrays.asList("a", "b", "c").forEach(Utils::printStatic);

        // 2. Instance method reference of a particular object
        MethodRefSimple obj = new MethodRefSimple();
        Arrays.asList("x", "y", "z").forEach(obj::printInstance);

        // 3. Instance method reference of an arbitrary object of a particular type
        String[] words = {"pear", "apple", "orange"};
        Arrays.sort(words, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(words));

        // 4. Constructor reference
        Arrays.asList("one", "two").forEach(s -> new MethodRefSimple());
    }
}
