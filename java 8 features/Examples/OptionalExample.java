package com.hcl.java8;
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        // Create an Optional with a value
        Optional<String> optional = Optional.of("hello");

        // Check if value is present
        if (optional.isPresent()) {
            // Get the value
            System.out.println("Value: " + optional.get());
        }

        // Create an empty Optional
        Optional<String> emptyOptional = Optional.empty();

        // Use orElse to provide a default
        String result = emptyOptional.orElse("default");
        System.out.println("Result: " + result);
    }
}
