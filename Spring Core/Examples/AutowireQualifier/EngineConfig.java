package com.cts.qualifier2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class EngineConfig {

	@Bean("dieselEngine")
	public Engine dieselEngine() {
		return new DieselEngine();
	}

	@Bean("petrolEngine")
	@Primary // This will be the default engine if no @Qualifier is used
	public Engine petrolEngine() {
		return new PetrolEngine();
	}
}
