package com.example.basic;

import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		
		Scanner s1 = new Scanner(System.in);

		int x = 6 % 5;
		switch (x) {

		case 0:
			System.out.println("x  value is 0");
			break;

		case 1:
			System.out.println("x  value is 1");
			break;

		case 2:
			System.out.println("x  value is 2");
			break;

		default:
			System.out.println("invalid");
			break;

		}
	}

}
