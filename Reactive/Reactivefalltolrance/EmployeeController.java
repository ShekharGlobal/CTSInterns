package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    
    @Autowired
    private EmployeeService service;   // use service for resilience

    @Autowired
    private EmployeeRepository repository;

    @PostMapping("save")
    public Mono<Employee> create(@RequestBody Employee emp) {
        // FIX: call service, not repository
        return service.saveEmployee(emp);
    }

    @GetMapping
    public Flux<Employee> getAll() {
        return repository.findAll();
    }

    @PostMapping("save2")
    public Mono<Employee> create2(@RequestBody Employee emp) {
        if (emp.getName() == null || emp.getName().isBlank()) {
            throw new IllegalArgumentException("Employee name must not be empty");
        }
        return repository.save(emp);
    }
}
