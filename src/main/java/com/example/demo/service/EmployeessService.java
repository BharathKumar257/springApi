package com.example.demo.service;

import java.util.List;

import com.example.demo.employeessentity.EmployeessEntity;

public interface EmployeessService {
	EmployeessEntity getByid(int employeeid);

	List<EmployeessEntity> getAll();

	EmployeessEntity postData(EmployeessEntity entity);

	EmployeessEntity updateData(int employeeid, EmployeessEntity entity);

	void deletData(int employeeid);

	EmployeessEntity patchdata(int employeeid);

	EmployeessEntity pacthing(EmployeessEntity entity);

}
