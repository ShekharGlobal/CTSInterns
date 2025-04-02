package com.cts.property;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Value;

@Configuration
@PropertySource("classpath:config.properties") // Load properties file
public class AppConfig {

	@Value("${app.name}")
	private String appName;

	@Value("${app.version}")
	private String appVersion;

	@Value("${app.environment}")
	private String appEnvironment;


	public void displayProperties() {
		System.out.println("App Name: " + appName);
		System.out.println("App Version: " + appVersion);
		System.out.println("App Environment: " + appEnvironment);
	}
}
