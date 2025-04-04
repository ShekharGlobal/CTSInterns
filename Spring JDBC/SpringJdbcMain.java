package com.coforge.springjdbc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringJdbcMain {
    public static void main(String[] args) {
    
    	AnnotationConfigApplicationContext context = new 
    			AnnotationConfigApplicationContext(SpringJdbcConfig.class);
        UserDao userDao = context.getBean(UserDao.class);

        try {
            userDao.createUser("error", "json@gmail.com");
            
        } catch (Exception e) {
            System.out.println("Transaction Rolled Back: " + e.getMessage());
        }
        context.close(); // Always close the context
    }
}
