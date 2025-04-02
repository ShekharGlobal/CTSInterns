package com.coforge.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.coforge.autoconfig")
public class AppConfig {
	
	@Bean
	public Address address() {
		
		Address address= new Address();
		address.setAddressLine1("CP");
		address.setCity("New Delhi");
		address.setState("Delhi");
		address.setCountry("India");
		return address;
		
	}
	
	@Bean
	public Employee employee() {
		Employee employee= new Employee();
		employee.setId(1);
		employee.setName("Vijay");
		//employee.setAddress(address());
		return employee;
		
	}

}
