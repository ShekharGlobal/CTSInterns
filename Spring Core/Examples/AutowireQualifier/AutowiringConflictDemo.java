package com.cts.qualifier2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AutowiringConflictDemo {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AutowiringConflictDemo.class, args);

        // Get the CarService Bean
        CarService carService = context.getBean(CarService.class);

        // Start the car (should use DieselEngine because of @Qualifier)
        carService.startCar();
    }
}
