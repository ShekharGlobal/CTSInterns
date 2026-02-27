package com.cts.rainbowjwellers.test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ParameterizedTestExample {

    @ParameterizedTest
    @CsvSource({
        "2, 3, 5",
        "10, 5, 15",
        "7, 3, 10"
    })
   
    void testAddition(int a, int b, int expectedSum) {
        assertEquals(expectedSum, add(a, b));
    }

    int add(int x, int y) {
        return x + y;
    }
}
