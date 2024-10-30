package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.employeessentity.EmployeessEntity;
import com.example.demo.serviceimple.EmployeessServiceImple;

@RestController
@RequestMapping(value = "/AllDetails")
public class EmployeessController {
	@Autowired
	EmployeessServiceImple impl;

	@GetMapping(value = "/{employeeid}")
	public EmployeessEntity getdata(@PathVariable int employeeid) {
		EmployeessEntity byid = impl.getByid(employeeid);
		return byid;
	}

	@GetMapping
	public List<EmployeessEntity> getalldata() {
		List<EmployeessEntity> all = impl.getAll();
		return all;
	}

	@PostMapping
	public EmployeessEntity postalldata(@RequestBody EmployeessEntity entity) {
		EmployeessEntity postData = impl.postData(entity);
		return postData;
	}

	@PutMapping(value = "/{employeeid}")
	public EmployeessEntity updatedata(@PathVariable int employeeid, @RequestBody EmployeessEntity entity) {
		EmployeessEntity updateData = impl.updateData(employeeid, entity);
		return updateData;

	}

	@DeleteMapping(value = "/{employeeid}")
	public void deletedata(@PathVariable int employeeid) {
		impl.deletData(employeeid);
	}

	@PatchMapping(value = "/{employeeid}")
	public ResponseEntity<EmployeessEntity> patchdata(@PathVariable int employeeid,
			@RequestBody EmployeessEntity entity) {
		EmployeessEntity patchdata = impl.patchdata(employeeid);
		if (patchdata == null) {
			return new ResponseEntity<EmployeessEntity>(HttpStatus.NOT_FOUND);
		}
		if (entity.getFirstname() != null) {
			patchdata.setFirstname(entity.getFirstname());
		}
		if (entity.getLastname() != null) {
			patchdata.setLastname(entity.getLastname());
		}
		if (entity.getDepartmentid() != 0) {
			patchdata.setDepartmentid(entity.getDepartmentid());
		}
		if (entity.getSalary() != null) {
			patchdata.setSalary(entity.getSalary());
		}
		if (entity.getHiredate() != null) {
			patchdata.setHiredate(entity.getHiredate());
		}
		return new ResponseEntity<EmployeessEntity>(impl.pacthing(patchdata), HttpStatus.ACCEPTED);
	}
}
