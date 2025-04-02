package com.cts.map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Load Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("map.xml");

        // Get the Library bean
        Library library = (Library) context.getBean("library");

        // Display the books with authors
        library.displayBooks();
    }
}
