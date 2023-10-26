package com.ty.hrms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.checkerframework.common.aliasing.qual.Unique;

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
public class SkillDTO {
	@NotBlank
	@NotNull
	@Unique
	private String skillName;
	@NotBlank
	@NotNull
	private String skillDescription;
}
