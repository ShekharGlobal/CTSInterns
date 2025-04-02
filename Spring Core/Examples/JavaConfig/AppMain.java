package com.coforge.autoconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {

	public static void main(String[] args) {
		
ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		Employee e1=  ctx.getBean("employee", Employee.class);
		
		e1.display();
	}

}
