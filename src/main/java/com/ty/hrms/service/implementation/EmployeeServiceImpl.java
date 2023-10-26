package com.ty.hrms.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ty.hrms.constants.EmployeeConstants;
import com.ty.hrms.dto.EmployeeDTO;
import com.ty.hrms.dto.SkillDTO;
import com.ty.hrms.dto.TrainingProgramDTO;
import com.ty.hrms.entity.Employee;
import com.ty.hrms.exception.EmployeeNotFoundException;
import com.ty.hrms.repository.EmployeeRepository;
import com.ty.hrms.service.EmployeeService;
import com.ty.hrms.util.HRMSUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeDTO> fetchAllEmployee() {
		return employeeRepository.findAll().stream().map(HRMSUtils::entityToDTO).collect(Collectors.toList());
	}

	@Override
	public EmployeeDTO fetchEmployeeById(String employeeId) {
		return HRMSUtils.entityToDTO(employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException(EmployeeConstants.EMPLOYEE_NOT_FOUND)));
	}

	@Override
	public List<TrainingProgramDTO> fetchEmployeeProgramsById(String employeeId) {
		return employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException(EmployeeConstants.EMPLOYEE_NOT_FOUND))
				.getTrainingPrograms().stream().map(HRMSUtils::entityToDTO).collect(Collectors.toList());
	}

	@Override
	public List<SkillDTO> fetchEmployeeSkillsById(String employeeId) {
		return employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException(EmployeeConstants.EMPLOYEE_NOT_FOUND)).getSkills()
				.stream().map(HRMSUtils::entityToDTO).collect(Collectors.toList());
	}

	@Override
	public Boolean removeEmployeeById(String employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException(EmployeeConstants.EMPLOYEE_NOT_FOUND));
		employee.setSkills(null);
		employee.setTrainingPrograms(null);
		employeeRepository.delete(employee);
		return true;
	}

}
