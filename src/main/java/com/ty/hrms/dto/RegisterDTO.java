package com.ty.hrms.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RegisterDTO {

	@NotNull
	@NotBlank
	private String password;
	@NotNull
	@NotBlank
	private String employeeFirstName;
	@NotNull
	@NotBlank
	private String employeeLastName;
	@NotNull
	@NotBlank
	@Email
	private String employeeEmailId;
	@NotNull
	private Long employeeContactNumber;
	@NotNull
	private LocalDate employeeJoiningDate;
	@NotNull
	@NotBlank
	private String employeeDepartment;
	@NotNull
	@NotBlank
	private String employeeDesignation;

	private List<SkillDTO> skills;

	private List<TrainingProgramDTO> trainingPrograms;

}
