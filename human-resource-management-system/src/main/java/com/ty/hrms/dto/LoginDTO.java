package com.ty.hrms.dto;

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

public class LoginDTO {
	@NotNull
	@NotBlank
	private String username;
	@NotNull
	@NotBlank
	private String password;
}
