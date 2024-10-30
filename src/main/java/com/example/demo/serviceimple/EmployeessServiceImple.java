package com.example.demo.serviceimple;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.employeessentity.EmployeessEntity;
import com.example.demo.repository.EmployeessRepository;
import com.example.demo.service.EmployeessService;

@Component
public class EmployeessServiceImple implements EmployeessService {
	@Autowired
	EmployeessRepository empl;

	@Override
	public EmployeessEntity getByid(int employeeid) {
		// TODO Auto-generated method stub
		EmployeessEntity GetById = null;
		Optional<EmployeessEntity> byId = empl.findById(employeeid);
		if (byId.isPresent()) {
			GetById = byId.get();
		}
		return GetById;
	}

	@Override
	public List<EmployeessEntity> getAll() {
		// TODO Auto-generated method stub
		List<EmployeessEntity> all = empl.findAll();
		return all;
	}

	@Override
	public EmployeessEntity postData(EmployeessEntity entity) {
		// TODO Auto-generated method stub
		EmployeessEntity save = empl.save(entity);
		return save;
	}

	@Override
	public EmployeessEntity updateData(int employeeid, EmployeessEntity entity) {
		// TODO Auto-generated method stub
		EmployeessEntity ForUpdate = null;
		Optional<EmployeessEntity> byId = empl.findById(employeeid);
		if (byId.isPresent()) {
			ForUpdate = byId.get();
			int employeeid2 = entity.getEmployeeid();
			String firstname = entity.getFirstname();
			String lastname = entity.getLastname();
			int departmentid = entity.getDepartmentid();
			BigDecimal salary = entity.getSalary();
			Date hiredate = entity.getHiredate();
			entity.setEmployeeid(employeeid2);
			entity.setFirstname(firstname);
			entity.setLastname(lastname);
			entity.setDepartmentid(departmentid);
			entity.setSalary(salary);
			entity.setHiredate(hiredate);
			EmployeessEntity save = empl.save(entity);
			return save;

		}
		return ForUpdate;
	}

	@Override
	public void deletData(int employeeid) {
		// TODO Auto-generated method stub

		Optional<EmployeessEntity> byId = empl.findById(employeeid);
		if (byId.isPresent()) {
			EmployeessEntity employeessentity3 = byId.get();
			empl.delete(employeessentity3);
		}

	}

	@Override
	public EmployeessEntity patchdata(int employeeid) {
		// TODO Auto-generated method stub
		Optional<EmployeessEntity> byId = empl.findById(employeeid);
		return byId.orElse(null);
	}

	@Override
	public EmployeessEntity pacthing(EmployeessEntity entity) {
		// TODO Auto-generated method stub
		EmployeessEntity save = empl.save(entity);
		return save;
	}

}
