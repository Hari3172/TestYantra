package com.ty.hrms.dto;

import java.time.LocalDate;
import java.util.List;

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
public class EmployeeDTO {
	private String employeeFirstName;
	private String employeeLastName;
	private String employeeEmailId;
	private Long employeeContactNumber;
	private LocalDate employeeJoiningDate;
	private String employeeDepartment;
	private String employeeDesignation;
	private List<SkillDTO> skills;

}
