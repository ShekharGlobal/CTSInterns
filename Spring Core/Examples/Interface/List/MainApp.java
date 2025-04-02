package com.cts.list;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		// Load Spring context
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

		// Get the Library bean
		Library library = (Library) context.getBean("library");

		// Display the books
		library.displayBooks();
	}
}
