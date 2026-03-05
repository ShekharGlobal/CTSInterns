package com.cts;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.cts.bean.Employee;
import com.cts.dao.EmployeeDAO;

@SpringBootApplication
@EnableJpaAuditing
public class SpringdatajpaApplication implements CommandLineRunner {

    private static final Logger logger =
            LoggerFactory.getLogger(SpringdatajpaApplication.class);

    @Autowired
    private EmployeeDAO employeeDAO;

    public static void main(String[] args) {
        SpringApplication.run(SpringdatajpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("Application started... Creating employee objects");

        Employee e1 = new Employee();
        e1.setEmpId("E1");
        e1.setEmpName("Vijay");
        e1.setDepartment("IT");
        e1.setSalary(50000);

        Employee e2 = new Employee();
        e2.setEmpId("E2");
        e2.setEmpName("David");
        e2.setDepartment("HR");
        e2.setSalary(40000);

        Employee e3 = new Employee();
        e3.setEmpId("E3");
        e3.setEmpName("Ravi");
        e3.setDepartment("IT");
        e3.setSalary(60000);

        Employee e4 = new Employee();
        e4.setEmpId("E4");
        e4.setEmpName("Manoj");
        e4.setDepartment("Finance");
        e4.setSalary(45000);

        logger.debug("Saving employees to database");

        employeeDAO.addEmployee(e1);
        employeeDAO.addEmployee(e2);
        employeeDAO.addEmployee(e3);
        employeeDAO.addEmployee(e4);

        logger.info("Employees saved successfully");

        logger.info("----- Fetching All Employees -----");

        List<Employee> list = employeeDAO.getAllEmployees();

        for (Employee emp : list) {
            logger.info("Employee: {} - Department: {}", 
                    emp.getEmpName(), emp.getDepartment());
        }

        logger.info("----- Pagination Example -----");

        Page<Employee> page = employeeDAO.getEmployeesByPage(0, 2);

        logger.info("Total Pages: {}", page.getTotalPages());
        logger.info("Total Records: {}", page.getTotalElements());

        page.getContent().forEach(emp ->
                logger.info("Employee: {}", emp.getEmpName()));

        logger.info("----- Sorting by Salary -----");

        List<Employee> sortedList = employeeDAO.getEmployeesSortedBySalary();

        sortedList.forEach(emp ->
                logger.info("Employee: {} - Salary: {}", 
                        emp.getEmpName(), emp.getSalary()));

        logger.info("----- Pagination + Sorting -----");

        Page<Employee> sortedPage = employeeDAO.getEmployeesPageSorted(0, 3);

        sortedPage.getContent().forEach(emp ->
                logger.info("Employee: {} - Salary: {}", 
                        emp.getEmpName(), emp.getSalary()));

        logger.warn("Application execution completed");
    }
}