package com.example.exception;

public class ExceptionDemo2 {

	public static void main(String[] args) {
		try {
		int x[]= {5, 7,8};
		System.out.println(x[1]);
		System.exit(000);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("invalid Index");
			
		}
		
		finally {
			System.out.println("Welcome");
		}

	}

}
