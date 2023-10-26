package com.ty.hrms.service;

import java.util.List;

import com.ty.hrms.dto.EmployeeDTO;
import com.ty.hrms.dto.SkillDTO;
import com.ty.hrms.dto.TrainingProgramDTO;

public interface EmployeeService {

	List<EmployeeDTO> fetchAllEmployee();

	EmployeeDTO fetchEmployeeById(String employeeId);

	Boolean removeEmployeeById(String employeeId);

	List<TrainingProgramDTO> fetchEmployeeProgramsById(String employeeId);

	List<SkillDTO> fetchEmployeeSkillsById(String employeeId);

}
