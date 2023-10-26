package com.ty.hrms.controller;

import static com.ty.hrms.constants.EmployeeConstants.EMPLOYEE_DATA_PROVIDED;
import static com.ty.hrms.constants.EmployeeConstants.EMPLOYEE_DELETED;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hrms.response.SuccessResponse;
import com.ty.hrms.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(path = "/api/employees")
@RestController
public class EmployeeController {

	private final EmployeeService employeeService;

	@GetMapping(path = "/")
	public ResponseEntity<SuccessResponse> getAllEmployee() {
		return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().data(employeeService.fetchAllEmployee())
				.message(EMPLOYEE_DATA_PROVIDED).timestemp(LocalDateTime.now()).build(), HttpStatus.ACCEPTED);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<SuccessResponse> getEmployeeById(@PathVariable(name = "id") String employeeId) {
		return new ResponseEntity<SuccessResponse>(
				SuccessResponse.builder().data(employeeService.fetchEmployeeById(employeeId))
						.message(EMPLOYEE_DATA_PROVIDED).timestemp(LocalDateTime.now()).build(),
				HttpStatus.ACCEPTED);
	}
	
	@GetMapping(path = "/employee-program/{id}")
	public ResponseEntity<SuccessResponse> getEmployeeProgramsById(@PathVariable(name = "id") String employeeId) {
		return new ResponseEntity<SuccessResponse>(
				SuccessResponse.builder().data(employeeService.fetchEmployeeProgramsById(employeeId))
				.message(EMPLOYEE_DATA_PROVIDED).timestemp(LocalDateTime.now()).build(),
				HttpStatus.ACCEPTED);
	}

	@GetMapping(path = "/employee-skill/{id}")
	public ResponseEntity<SuccessResponse> getEmployeeSkillsById(@PathVariable(name = "id") String employeeId) {
		return new ResponseEntity<SuccessResponse>(
				SuccessResponse.builder()
				.data(employeeService.fetchEmployeeSkillsById(employeeId))
				.message(EMPLOYEE_DATA_PROVIDED).timestemp(LocalDateTime.now()).build(),
				HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<SuccessResponse> removeEmployeeById(@PathVariable(name = "id") String employeeId) {
		return new ResponseEntity<SuccessResponse>(
				SuccessResponse.builder().data(employeeService.removeEmployeeById(employeeId)).message(EMPLOYEE_DELETED)
						.timestemp(LocalDateTime.now()).build(),
				HttpStatus.ACCEPTED);
	}

}
