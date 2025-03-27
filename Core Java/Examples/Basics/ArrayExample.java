package com.example.arrays;
class Employee {
    String name;
    int id;

    // Constructor
    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Method to display employee details
    void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}

public class ArrayExample {
    public static void main(String[] args) {
    	//==================option-1===================================================
        // Declaring an array of Employee objects
        Employee[] emp;

        // Initializing the array to hold 3 Employee objects
        emp = new Employee[3];

        // Creating Employee objects and assigning them to the array
        emp[0] = new Employee("Vijay", 101);
        emp[1] = new Employee("Venkat", 102);
        emp[2] = new Employee("Monika", 103);
        
     // Displaying the Employee details
        for (Employee e : emp) {
            e.display();
        }
        //======================================================================================
        //option-2
        Employee[] empdirect = {
                new Employee("Vijay", 101),
                new Employee("Venkat", 102),
                new Employee("Monika", 103)
            };
        
        for (Employee e : empdirect) {
            e.display();
        }
    }
}
