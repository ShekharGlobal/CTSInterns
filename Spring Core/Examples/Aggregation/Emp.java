package com.coforge.aggregation;
//Aggregation
public class Emp {

	int id;
	String name;
	Address address;//dependency

	public Emp(int id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public void display() {

		System.out.println(id + " " + name);
		System.out.println(address.city + " " + address.state + " " + address.country);
	}

	
	public static void main(String[] args) {

		Address a1 = new Address("Chennai", "TN", "India");
		Address a2 = new Address("Hyderabad", "Telangana", "India");
		
		
		Emp e= new Emp(1, "Venakt",a1);
		Emp e2= new Emp(2, "Sai",a2);
		
		
		e.display();
		e2.display();
	}
}
