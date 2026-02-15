package com.hcl.java8;

public class Test2 implements Readable{
	//Traditional
	@Override
	public void getName() {
		System.out.println("Rohit");
		
	}

	public static void main(String[] args) {

		//Annynomous
		Readable r1 = new Readable() {

			@Override
			public void getName() {
				System.out.println("Vikash");

			}
		};

		r1.getName();
		
		//Lambda
		Readable r2=()->{
			System.out.println("Priya");
		};
		r2.getName();

	}

	

}
