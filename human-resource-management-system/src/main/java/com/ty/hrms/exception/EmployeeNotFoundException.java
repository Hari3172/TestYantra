package com.ty.hrms.exception;
public class EmployeeNotFoundException extends RuntimeException{
	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
