package com.cts.property;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainApp {
    public static void main(String[] args) {
        // Create Spring container
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        // Get the bean and run the displayProperties method
        context.getBean(AppConfig.class).displayProperties();
        
        // Close context
        context.close();
    }
}
