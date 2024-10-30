package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.employeessentity.EmployeessEntity;

public interface EmployeessRepository extends JpaRepository<EmployeessEntity, Integer> {

}
