package com.cts.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.Employee;
import com.cts.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
//http://localhost:2024/employees/all
//http://localhost:2024/employees/all?page=0&size=5
//http://localhost:2024/employees/all?page=1&size=5
//http://localhost:2024/employees/all?sortBy=salary&direction=desc
//http://localhost:2024/employees/all?sortBy=name&direction=asc
//http://localhost:2024/employees/all?page=0&size=5&sortBy=name&direction=asc
 
    @GetMapping("/all")
    public Page<Employee> getEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        return employeeService.getEmployees(page, size, sortBy, direction);
    }
}
