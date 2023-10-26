package com.ty.hrms.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hrms.response.SuccessResponse;
import com.ty.hrms.service.TrainingProgramService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(path = "/api/programs")
@RestController
public class TrainingProgramController {

	private final TrainingProgramService trainingProgramService;
	
	@GetMapping(path = "/")
	public ResponseEntity<SuccessResponse> getAllTrainingProgram() {
		return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().data(trainingProgramService.fetchAllTrainingProgram()).message("Program Data Provided")
				.timestemp(LocalDateTime.now()).build(), HttpStatus.ACCEPTED);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<SuccessResponse> getTrainingProgramById(@PathVariable(name = "id") Integer trainingProgramId) {
		return new ResponseEntity<SuccessResponse>(
				SuccessResponse.builder().data(trainingProgramService.fetchTrainingProgramById(trainingProgramId))
						.message("Program Data Provided").timestemp(LocalDateTime.now()).build(),
				HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<SuccessResponse> removeTrainingProgramById(@PathVariable(name = "id") Integer trainingProgramId) {
		return new ResponseEntity<SuccessResponse>(
				SuccessResponse.builder().data(trainingProgramService.removeTrainingProgramById(trainingProgramId))
						.message("Program Deleted").timestemp(LocalDateTime.now()).build(),
				HttpStatus.ACCEPTED);
	}

}
