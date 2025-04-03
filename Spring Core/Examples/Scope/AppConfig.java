package com.coforge.scope;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.coforge.scope")  //Scans the specified package for annotated components
public class AppConfig {
}
