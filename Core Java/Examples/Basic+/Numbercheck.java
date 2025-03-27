package com.example.basic;
public class Numbercheck {
    void displayBigNumber(int num1, int num2, int num3) {
        int biggestNumber;

        if (num1 > num2) {
            if (num1 > num3) {
                biggestNumber = num1;
            } else if (num3 > num2) {
                biggestNumber = num3;
            } else {
                biggestNumber = num2;
            }
        } else if (num2 > num3) {
            biggestNumber = num2;
        } else {
            biggestNumber = num3;
        }

        System.out.println(biggestNumber + " is the biggest number");
    }
}

