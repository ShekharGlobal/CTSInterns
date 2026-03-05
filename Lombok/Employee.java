package com.cts.bean;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
@EntityListeners(AuditingEntityListener.class)
public class Employee {

	@Id
	@Column(name = "emp_id")
	private String empId;

	@Column(name = "emp_name")
	private String empName;

	@Column(name = "department")
	private String department;

	@Column(name = "salary")
	private double salary;

	// Auditing Fields

	@CreatedDate
	@Column(name = "created_date")
	private LocalDateTime createdDate;

	@LastModifiedDate
	@Column(name = "last_modified_date")
	private LocalDateTime lastModifiedDate;

	@CreatedBy
	@Column(name = "created_by")
	private String createdBy;

	@LastModifiedBy
	@Column(name = "last_modified_by")
	private String lastModifiedBy;

}