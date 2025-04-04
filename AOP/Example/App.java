package com.cts.SpringAopDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

/**
 * Main class to simulate bank operations using Spring AOP.
 * 
 * The application prompts the user to choose various banking options such as deposit, 
 * withdraw, change PIN, or view balance. It integrates AOP for validation and 
 * handling of cross-cutting concerns like logging and PIN validation.
 */
public class App {
    public static void main(String[] args) {

        // Initialize Spring ApplicationContext from AopConfig class
        ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        
        // Retrieve the EasyBank bean from the Spring container
        EasyBank bank = context.getBean(EasyBank.class);

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        int pin = 0;
        int amount = 0;

        // Loop to display menu and process bank operations
        do {
System.out.println("\nSelect option \n 1.Deposit\n 2.Withdraw\n 3.Change Pin\n 4.Show Balance\n 5.Exit");
            choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1: {  // Deposit money
                        System.out.println("Enter amount to deposit");
                        amount = scanner.nextInt();
                        System.out.println("Enter pin");
                        pin = scanner.nextInt();
                        bank.setTempPin(pin);
                        bank.doDeposit(amount);
                        break;
                    }
                    case 2: {  // Withdraw money
                        System.out.println("Enter amount to withdraw");
                        amount = scanner.nextInt();
                        System.out.println("Enter pin");
                        pin = scanner.nextInt();
                        bank.setTempPin(pin);
                        bank.doWithdraw(amount);
                        break;
                    }
                    case 3: {  // Change PIN
                        System.out.println("Enter your current pin");
                        int oldPin = scanner.nextInt();
                        System.out.println("Enter 4 digit new pin");
                        pin = scanner.nextInt();
                        bank.doChangePin(oldPin, pin);
                        break;
                    }
                    case 4: {  // Show balance
                        System.out.println("Enter pin");
                        pin = scanner.nextInt();
                        bank.setTempPin(pin);
                        bank.showBalance();
                        break;
                    }
                    case 5: {  // Exit application
                        System.out.println("Thanks for using our service");
                        break;
                    }
                    default: {  // Invalid option
                        System.out.println("Wrong choice");
                    }
                }
            } catch (Exception ignore) {
                // Handle exception (invalid pin or other runtime issues)
            }
        } while (choice != 5);  // Repeat until user chooses to exit
    }
}
