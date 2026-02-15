package com.hcl.java8;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
/**
 * Use Predicate when you need to test a condition and return 
 * a boolean.
   Use Function when you need to transform an input into an output
   and return a result.
 * @author Shekhar
 *
 */
public class StreamExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "", "banana", "cherry");

        // Predicate: Filter non-empty strings
        Predicate<String> isNonEmpty = str -> !str.isEmpty();

        // Function: Get the length of each string
        Function<String, Integer> stringLength = str -> str.length();

        // Filter and map the stream
        List<Integer> lengths = strings.stream()
                                       .filter(isNonEmpty)
                                       .map(stringLength)
                                       .collect(Collectors.toList());

        System.out.println(lengths);  // Output: [5, 6, 6]
    }
}
