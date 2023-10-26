package com.ty.hrms.controller;

import static com.ty.hrms.constants.SkillConstants.SKILL_DATA_PROVIDED;
import static com.ty.hrms.constants.SkillConstants.SKILL_DELETED;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hrms.response.SuccessResponse;
import com.ty.hrms.service.SkillService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(path = "/api/skills")
@RestController
public class SkillController {
	
	private final SkillService skillService;

	@GetMapping(path = "/")
	public ResponseEntity<SuccessResponse> getAllskill() {
		return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().data(skillService.fetchAllskill()).message(SKILL_DATA_PROVIDED)
				.timestemp(LocalDateTime.now()).build(), HttpStatus.ACCEPTED);
	}

	@PostMapping(path = "/{id}")
	public ResponseEntity<SuccessResponse> getSkillById(@PathVariable(name = "id") Integer skillId) {
		return new ResponseEntity<SuccessResponse>(
				SuccessResponse.builder().data(skillService.fetchSkillById(skillId))
						.message(SKILL_DATA_PROVIDED).timestemp(LocalDateTime.now()).build(),
				HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<SuccessResponse> removeSkillById(@PathVariable(name = "id") Integer SkillId) {
		return new ResponseEntity<SuccessResponse>(
				SuccessResponse.builder().data(skillService.removeSkillById(SkillId))
						.message(SKILL_DELETED).timestemp(LocalDateTime.now()).build(),
				HttpStatus.ACCEPTED);
	}

}
