package com.cts.qualifier2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


/**
 * Spring injects dependencies by type using constructor-based autowiring when 
 * you use @Autowired. It looks for a bean of the matching type (Engine in this case). 
 * 
 * If there are multiple beans of the same type, Spring will need further information 
 * (like @Qualifier or @Primary) to decide which one to inject.
 * 
 * Type-based injection means Spring will match the constructor parameter type (Engine)
 *  with one of the available beans of type Engine in the application context.
 * 
 * @author Shekhar
 *
 */
@Service
public class CarService {

	private final Engine engine; // Type: Engine

	// Using @Qualifier to specify the desired bean
	@Autowired // Autowires by type (Engine)
	public CarService(@Qualifier("dieselEngine") Engine engine) {
		this.engine = engine;
	}

	public void startCar() {
		engine.start();
	}
}
