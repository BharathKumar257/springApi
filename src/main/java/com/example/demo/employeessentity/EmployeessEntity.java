package com.example.demo.employeessentity;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPLOYEES")

public class EmployeessEntity {
	@Id
	@Column(name = "EMPLOYEE_ID")
	private int employeeid;
	@Column(name = "FIRST_NAME")
	private String firstname;
	@Column(name = "LAST_NAME")
	private String lastname;
	@Column(name = "DEPARTMENT_ID")
	private int departmentid;
	@Column(name = "SALARY")
	private BigDecimal salary;
	@Column(name = "HIRE_DATE")
	private Date hiredate;
}
