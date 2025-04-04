package com.cts.SpringAopDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * EasyBank class simulates basic banking operations such as deposit, withdrawal, 
 * PIN change, and balance inquiry. It is annotated as a Spring component for 
 * dependency injection.
 */
@Component
public class EasyBank {
    
    private int pinCode;
    private int balance;
    private int tempPin;

    public int getPinCode() {
        return pinCode;
    }

    @Value("6789")  // Default PIN value injected by Spring
    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public int getBalance() {
        return balance;
    }

    @Value("10000")  // Default balance value injected by Spring
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getTempPin() {
        return tempPin;
    }

    public void setTempPin(int tempPin) {
        this.tempPin = tempPin;
    }

    /**
     * Withdraws a specified amount from the balance if sufficient funds are available.
     * 
     * @param amount the amount to withdraw
     */
    public void doWithdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("You have successfully withdrawn " + amount);
        } else {
            System.out.println("Insufficient Fund");
        }
    }

    /**
     * Deposits a specified amount into the balance.
     * 
     * @param amount the amount to deposit
     */
    public void doDeposit(int amount) {
        balance += amount;
        System.out.println("Your balance is " + balance);
    }

    /**
     * Changes the PIN if the old PIN matches the current PIN.
     * 
     * @param oldPin the current PIN
     * @param pin    the new PIN to set
     * @throws RuntimeException if the old PIN doesn't match the current PIN
     */
    public void doChangePin(int oldPin, int pin) {
        if (oldPin == pinCode) {
            pinCode = pin;
        } else {
            throw new RuntimeException("Incorrect PIN");
        }
    }

    /**
     * Displays the current balance.
     */
    public void showBalance() {
        System.out.println("Your balance is " + balance);
    }
}
