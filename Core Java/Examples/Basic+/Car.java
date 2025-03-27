package com.cts.oops2;
//Super Class/Parent Class/ Base class
public class Car {
	
	public void getDrive() {
		System.out.println("Cool");
	}

}

//Sub class/child class/Derived class
class Hyundai extends Car{
	
	public void getMilage() {
		System.out.println("15KMPL");
	}
	
}

class Venue extends Hyundai{
	
	public void MaxSpeed() {
		System.out.println("200KMPH");
	}
}
