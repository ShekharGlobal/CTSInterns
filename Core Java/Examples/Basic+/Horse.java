package com.cts.oops2;

class Animal {
	
	int x=100;

	protected void run() {
		System.out.println("animal Is Running");
	}
}

public class Horse extends Animal {

	int x=200;
	public void run() {
		//super.run();
		System.out.println("Horse Is Running");
	}
	public static void main(String[] args) {
		
		
		//upcasting
		Animal a1= new Horse();
		a1.run();
		
		System.out.println(a1.x);
		
		/*
		 * Horse h2= (Horse) new Animal(); h2.run();
		 */
		
		

	}

}
