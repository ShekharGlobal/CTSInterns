package com.example.basic;

public class Scope {
	
	
	int x=100;//instance variable
	
	public void detail() {  //instance method 1
		x=500;
		int y=200; //local variable
		System.out.println(x);
	}
	
	public void detail2() {  //instance method 2
		x=600;
		//y=700;
		System.out.println(x);
	}

	public static void main(String[] args) {
		
		Scope s1= new Scope();
		s1.detail2();
		s1.detail();
		

	}

}
