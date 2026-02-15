package com.hcl.java8;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CombinedExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 8, 3, 5, 2, 4, 7);

        // Stream operations:
        // 1. Remove duplicates
        // 2. Filter numbers greater than 4
        // 3. Sort in ascending order
        // 4. Square each number
        // 5. Limit the result to the first 3 elements
        List<Integer> result = numbers.stream()
                                      .distinct()  // Remove duplicates
                                      .filter(n -> n > 4)  // Filter numbers > 4
                                      .sorted()  // Sort in ascending order
                                      .map(n -> n * n)  // Square each number
                                      .limit(3)  // Limit to first 3 results
                                      .collect(Collectors.toList());

        System.out.println("Result: " + result);  // Output: [25, 49, 64]
    }
}
