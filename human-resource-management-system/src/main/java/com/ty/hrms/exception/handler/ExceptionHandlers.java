package com.ty.hrms.exception.handler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ty.hrms.exception.EmployeeAlreadyExistException;
import com.ty.hrms.exception.EmployeeNotFoundException;
import com.ty.hrms.exception.RoleNotFoundException;
import com.ty.hrms.exception.SkillNotFoundException;
import com.ty.hrms.response.ErrorResponse;

@RestControllerAdvice
public class ExceptionHandlers {

	@ExceptionHandler(value = { RoleNotFoundException.class, EmployeeNotFoundException.class,
			UsernameNotFoundException.class, SkillNotFoundException.class})
	public ResponseEntity<ErrorResponse> handler(RuntimeException exception) {
		return new ResponseEntity<ErrorResponse>(
				ErrorResponse.builder().error(exception.getMessage()).timestamp(LocalDateTime.now()).build(),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { EmployeeAlreadyExistException.class })
	public ResponseEntity<ErrorResponse> handler_(RuntimeException exception) {
		return new ResponseEntity<ErrorResponse>(
				ErrorResponse.builder().error(exception.getMessage()).timestamp(LocalDateTime.now()).build(),
				HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = { SQLIntegrityConstraintViolationException.class })
	public ResponseEntity<ErrorResponse> handler_(SQLIntegrityConstraintViolationException exception) {
		return new ResponseEntity<ErrorResponse>(
				ErrorResponse.builder().error(exception.getMessage()).timestamp(LocalDateTime.now()).build(),
				HttpStatus.CONFLICT);
	}

}
