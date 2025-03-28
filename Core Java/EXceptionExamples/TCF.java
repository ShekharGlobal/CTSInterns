package com.example.exception;

public class TCF {
	
	int quotient=0;
	
	public void divide(int x, int y) {
		try {
		quotient= x/y;
		}
		catch(ArithmeticException e) {
			System.out.println("cannot divide by Zero");
		}
		finally {
			System.out.println(quotient);
		}
	
	}

	public static void main(String[] args) {
		TCF t1= new TCF();
		t1.divide(20, 0);
		t1.divide(20, 2);
 
	}

}
