package com.hcl.java8;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class FunctionalProgrammingDemo {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Alex", "Brian");

        /* --------------------------------------------------
           1. Predicate (filtering)
        -------------------------------------------------- */

        Predicate<String> startsWithA = name -> name.startsWith("A");

        List<String> filtered =
                names.stream()
                     .filter(startsWithA)
                     .collect(Collectors.toList());

        System.out.println("Starts with A: " + filtered);

        /* --------------------------------------------------
           2. Function (mapping / transformation)
        -------------------------------------------------- */

        Function<String, Integer> lengthFunction = name -> name.length();

        List<Integer> lengths =
                names.stream()
                     .map(lengthFunction)
                     .collect(Collectors.toList());

        System.out.println("Lengths: " + lengths);

        /* --------------------------------------------------
           3. Consumer (side effects)
        -------------------------------------------------- */

        Consumer<String> printer = name -> System.out.println("Hello " + name);

        names.forEach(printer);

        /* --------------------------------------------------
           4. Supplier (lazy value generation)
        -------------------------------------------------- */

        Supplier<Double> randomSupplier = () -> Math.random();

        System.out.println("Random value: " + randomSupplier.get());

        /* --------------------------------------------------
           5. Method References
        -------------------------------------------------- */

        // Lambda
        names.forEach(name -> System.out.println(name));

        // Method reference (cleaner)
        names.forEach(System.out::println);

        /* --------------------------------------------------
           6. Sorting with Lambda
        -------------------------------------------------- */

        List<String> sorted = new ArrayList<>(names);

        sorted.sort((a, b) -> a.length() - b.length());
        System.out.println("Sorted by length: " + sorted);

        /* --------------------------------------------------
           7. Sorting with Method Reference
        -------------------------------------------------- */

        sorted.sort(Comparator.comparingInt(String::length));
        System.out.println("Sorted by length (method ref): " + sorted);

        /* --------------------------------------------------
           8. Reduce (aggregation)
        -------------------------------------------------- */

        int totalLength =
                names.stream()
                     .map(String::length)
                     .reduce(0, Integer::sum);

        System.out.println("Total length: " + totalLength);

        /* --------------------------------------------------
           9. Custom Functional Interface
        -------------------------------------------------- */

        StringFormatter formatter = (str) -> str.toUpperCase();

        System.out.println("Formatted: " + formatter.format("functional programming"));
    }

    /* --------------------------------------------------
       Custom Functional Interface
    -------------------------------------------------- */

    @FunctionalInterface
    interface StringFormatter {
        String format(String input);
    }
}
