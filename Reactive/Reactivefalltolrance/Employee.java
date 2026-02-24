package com.app;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @Entity:Comes from JPA (Java Persistence API).

   It’s used in Spring Data JPA for ORM with Hibernate.

   R2DBC is not JPA-based, so @Entity is ignored or causes unexpected 
   behavior.
 */

@Table("employee")
public class Employee {
	
    @Id  
    
    private long id;
    private String name;
    private String department;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
    
    
    
    
    
    
}
