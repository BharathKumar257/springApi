package com.example.demo.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.employeessentity.EmployeessEntity;


@Configuration
public class EmployeeRestTemplate {
	@Autowired
	RestTemplate rest;
	
	
	public EmployeessEntity getEmployeeDetails(int employeeid) {
		ResponseEntity<EmployeessEntity> exchanges =rest.exchange("http://localhost:8082/Informations/{Employeeid}",HttpMethod.GET, null, EmployeessEntity.class);
		EmployeessEntity body=exchanges.getBody();
		return body;
	}

}
