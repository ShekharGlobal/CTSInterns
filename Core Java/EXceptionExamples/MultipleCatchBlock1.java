package com.example.exception;

public class MultipleCatchBlock1 {

	public static void main(String[] args) {

		try {
			int a[] = new int[5];
			a[4] = 30 / 2;
			System.out.println(a[4]);

		}

		catch (ArithmeticException e) {
			System.out.println("Arithmetic Exception occurs");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBounds Exception occurs");
		}

		System.out.println("rest of the code");
	}
}