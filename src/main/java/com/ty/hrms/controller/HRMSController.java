package com.ty.hrms.controller;

import static com.ty.hrms.constants.EmployeeConstants.EMPLOYEE_REGISTERED;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hrms.dto.LoginDTO;
import com.ty.hrms.dto.RegisterDTO;
import com.ty.hrms.response.SuccessResponse;
import com.ty.hrms.service.HRMSService;
import com.ty.hrms.util.JwtsUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(path = "/api/auth")
@RestController
public class HRMSController {

	private final AuthenticationManager authenticationManager;
	private final HRMSService hrmsService;
	private final JwtsUtils jwtsUtils;

	@PostMapping(path = "/register")
	public ResponseEntity<SuccessResponse> employeeRegister(@RequestBody RegisterDTO registerDTO) {
		return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().data(hrmsService.register(registerDTO))
				.message(EMPLOYEE_REGISTERED).timestemp(LocalDateTime.now()).build(), HttpStatus.CREATED);
	}

	@PostMapping(path = "/login")
	public ResponseEntity<SuccessResponse> login(@RequestBody LoginDTO loginDTO) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
		return new ResponseEntity<SuccessResponse>(SuccessResponse.builder()
				.token(jwtsUtils.generateToken(loginDTO.getUsername())).timestemp(LocalDateTime.now()).build(),
				HttpStatus.ACCEPTED);

	}

}
