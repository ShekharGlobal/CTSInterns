package com.coforge.constructor;

/**
 * Service Class:
  The Address class serves as the service class because it provides
   the address details that Employee depends on.
 * @author Shekhar
 *
 */

public class Address {

	private String addressLine1;
	private String city;
	private String state;
	private String country;

	// Constructor for constructor-based injection
	public Address(String addressLine1, String city, String state, String country) {
		this.addressLine1 = addressLine1;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	@Override
	public String toString() {
	return "Address [addressLine1=" + addressLine1 + ", city=" + city + ", state=" + state + ", country=" + country + "]";
	}
}
