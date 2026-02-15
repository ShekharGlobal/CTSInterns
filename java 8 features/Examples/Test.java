package com.hcl.java8;

public class Test {
	
	


	public static void main(String[] args) {
		
		Readable r1= new Readable() {
			
			@Override
			public void getName() {
			System.out.println("Priyanka");
				
			}
		};
		
		r1.getName();
	}

	
}
