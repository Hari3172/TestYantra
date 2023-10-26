package com.ty.hrms.dto;

import java.time.LocalDate;

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
public class TrainingProgramDTO {

	@NotNull
	@NotBlank
	private String programName;

	@NotNull
	@NotBlank
	private String programDescription;

	@NotNull
	private LocalDate programStartDate;

	@NotNull
	private LocalDate programEndDate;
}
