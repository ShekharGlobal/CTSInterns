package com.cts.oops;

public class StaticDemo {
	
	static int x=0;// static/global/class member
	int y =3;// instance member
	
	StaticDemo(){
		x++;
		y=y+5;
		System.out.println("Static X value: "+ x);
		System.out.println("Non Static y value: "+ y);
	}

	public static void main(String[] args) {
		StaticDemo s1= new StaticDemo();//1,8/0,8/
		StaticDemo s2= new StaticDemo();//2,8/
		StaticDemo s3= new StaticDemo();//3,8/2,8
		
		

	}

}
