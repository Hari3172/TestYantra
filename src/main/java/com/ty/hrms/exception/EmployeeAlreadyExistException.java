package com.ty.hrms.exception;

public class EmployeeAlreadyExistException extends RuntimeException{
	public EmployeeAlreadyExistException(String message) {
		super(message);
	}
}
