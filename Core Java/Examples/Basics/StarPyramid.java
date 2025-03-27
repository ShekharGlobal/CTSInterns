package com.example.arrays;
public class StarPyramid {
    public static void main(String[] args) {
        // Declaring and initializing a 2D array using curly braces
        char[][] pyramid = {
            {'*'},
            {'*', '*'},
            {'*', '*', '*'},
            {'*', '*', '*', '*'},
            {'*', '*', '*', '*', '*'}
        };

        // Printing the pyramid
        for (int i = 0; i < pyramid.length; i++) {
            // Printing spaces for alignment
            for (int space = 0; space < pyramid.length - i - 1; space++) {
                System.out.print(" "); 
            }

            // Printing stars
            for (int j = 0; j < pyramid[i].length; j++) {
                System.out.print(pyramid[i][j] + " ");
            }

            System.out.println(); // Move to the next line
        }
    }
}
