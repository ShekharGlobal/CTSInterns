package com.hcl.java8;

public class WithoutLambda {

	public static void main(String[] args) {

		Readable r1 = new Readable() {
			public void getName() {
				System.out.println("Ajay");
			}
		};
		r1.getName();

		

	}

}
