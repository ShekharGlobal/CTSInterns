package com.cts.oops;

public class StudentRecord extends Object{
	String name;
	int studentId;
	String grade;

	// one parameter
	public StudentRecord(String name) {
		super();
		this.name = name;
	}

//two
	public StudentRecord(String name, int studentId) {
		super();
		this.name = name;
		this.studentId = studentId;
	}

//three
	public StudentRecord(String name, int studentId, String grade) {
		super();
		this.name = name;
		this.studentId = studentId;
		this.grade = grade;
	}

	// default
	public StudentRecord() {
		super();
	}

	public static void main(String[] args) {

		StudentRecord s1 = new StudentRecord("Stefka");
		StudentRecord s2 = new StudentRecord("Sneha", 121);
		StudentRecord s3 = new StudentRecord("Stefen", 122, "A++");

		System.out.println("Student Name: " + s1.name);
		System.out.println("Student Name: " + s2.name + " " + "Student's Id: " + s2.studentId);
		System.out.println("Student Name: " + s3.name + " " + "Student's Id:" + s3.studentId + " " + " Student's Grade "
				+ s3.grade);

	}

}
