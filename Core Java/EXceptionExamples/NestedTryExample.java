package com.example.exception;
import java.util.Scanner;

public class NestedTryExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Outer try block");
            try {
                System.out.println("Inner try block");
                System.out.print("Enter a number: ");
                int x = scanner.nextInt();
                int y = 10 / x;
                System.out.println("Result: " + y);
            } catch (NullPointerException e) {
                System.out.println("Caught ArithmeticException in inner try block");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Caught ArrayIndexOutOfBounds in Exception block: " + e.getMessage());
            } finally {
                System.out.println("Inner finally block");
            }
        } catch (Exception e) {
            System.out.println("Caught Exception in outer try block: " + e.getMessage());
        } finally {
            System.out.println("Outer finally block");
        }
    }
}
