package com.example.arrays;
public class ArrayDemo {
    
	int[] numbers;

    public void storeNumbers() {
        numbers = new int[101];
        for (int i = 0; i < 100; i++)
            numbers[i] = i;
    }

    public void printEvenNumber() {
        System.out.println("The even numbers between 0 and 100 are:");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0)
                System.out.println(numbers[i]);
        }
    }

    public static void main(String args[]) {
        ArrayDemo arrayDemo = new ArrayDemo();
        arrayDemo.storeNumbers();
        arrayDemo.printEvenNumber();
    }
}
