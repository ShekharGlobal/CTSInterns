package com.example.basic;
public class StudentRecord {
    private String name;

    public StudentRecord() {
        this("John"); // Calls the parameterized constructor
    }

    public StudentRecord(String name) {
        this.name = name; // Assigns the passed value to the name variable
    }

    public static void main(String[] args) {
        StudentRecord firstStudent = new StudentRecord(); // Calls default constructor
        System.out.println(firstStudent.name); // Outputs "John"
    }
}
