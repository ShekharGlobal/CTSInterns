package com.coforge.constructor;

/**
 * Injector Class: Spring Container (configured using cons.xml).

    Service Class: Address (provides address details).

   Client Class: Employee (depends on Address).

    MainApp: Entry point (retrieves beans and triggers execution).
 * 
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
    	//This loads the Spring configuration file (cons.xml) and initializes the beans.
        ApplicationContext context = new ClassPathXmlApplicationContext("cons.xml");

        // The obj bean (an instance of Employee) is fetched from the Spring context.
        //casts it to an Employee object, and assigns it to the emp1 variable.
        Employee emp1 = (Employee) context.getBean("obj");
        

        // Displaying employee details
        emp1.display();
        
}
}
