package com.coforge.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {

    public static void main(String[] args) {
        
        // Load the application context from the configuration class
    ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        
        Employee e1 =  ctx.getBean(Employee.class);
        e1.setCity("Banglore");
        e1.display();
        
        Employee e2 = ctx.getBean(Employee.class);
        
        e2.display();
    }
}
