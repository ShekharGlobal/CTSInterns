package com.app;

import java.time.Duration;

import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

	private final EmployeeRepository repository;

	public EmployeeService(EmployeeRepository repository) {
		this.repository = repository;
	}

	@CircuitBreaker(name = "employeeServiceCB", fallbackMethod = "fallbackEmployee")
	@Retry(name = "employeeServiceRetry")
	@TimeLimiter(name = "employeeServiceTL")
	public Mono<Employee> saveEmployee(Employee emp) {
		if ("fail".equalsIgnoreCase(emp.getName())) {
			return Mono.error(new RuntimeException("Forced failure for CB demo"));
		}
		return Mono.delay(Duration.ofSeconds(3)).flatMap(t -> repository.save(emp));
	}

	private Mono<Employee> fallbackEmployee(Employee emp, Throwable t) {
		Employee fallback = new Employee();
		fallback.setId(-1);
		fallback.setName("Fallback Employee");
		fallback.setDepartment("N/A");
		return Mono.just(fallback);
	}
}
