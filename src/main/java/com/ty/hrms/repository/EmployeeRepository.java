package com.ty.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hrms.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{

}
