package com.coforge.constructor;

/**
 * Client Class:

 The Employee class is the client class because it depends on Address, 
 which is injected into it via constructor injection
 * @author Shekhar
 *
 */

public class Employee {

	private int id; 
	private String name;
	private Address address; //dependency

	// Constructor for constructor-based injection
	public Employee(int id, String name, Address address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public void display() {
		System.out.println(id + " " + name);
		System.out.println(address);
	}
}
