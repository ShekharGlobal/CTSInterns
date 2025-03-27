package com.example.basic;
public class TestProgramTransfer {
    public static void main(String[] args) {
        int count = 5;
        int i;
        WelcomeMessage welcome = new WelcomeMessage();

        for (i = 1; i <= count; i++) {
            welcome.printMessage();
            
            if (i == 3) { // When i == 3, return stops execution
                continue;
            }
            System.out.println("After if loop " + i);
        }

        // These lines will NOT execute because of `return` in the loop
        
        System.out.println("Final returned value of i is " + i);
    }
}