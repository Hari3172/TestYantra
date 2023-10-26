package com.ty.hrms.util;

import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ty.hrms.dto.EmployeeDTO;
import com.ty.hrms.dto.RegisterDTO;
import com.ty.hrms.dto.SkillDTO;
import com.ty.hrms.dto.TrainingProgramDTO;
import com.ty.hrms.entity.Employee;
import com.ty.hrms.entity.Skill;
import com.ty.hrms.entity.TrainingProgram;

@Component
public class HRMSUtils {

	public static Employee dtoToEntity(RegisterDTO registerDTO) {
		Employee employee = Employee.builder().build();
		BeanUtils.copyProperties(registerDTO, employee);
		return employee;
	}

	public static Skill dtoToEntity(SkillDTO skillDTO) {
		Skill skill = Skill.builder().build();
		BeanUtils.copyProperties(skillDTO, skill);
		return skill;
	}

	public static TrainingProgram dtoToEntity(TrainingProgramDTO trainingProgramDTO) {
		TrainingProgram trainingProgram = TrainingProgram.builder().build();
		BeanUtils.copyProperties(trainingProgramDTO, trainingProgram);
		return trainingProgram;
	}

	public static EmployeeDTO entityToDTO(Employee employee) {
		EmployeeDTO employeeDTO = EmployeeDTO.builder().build();
		BeanUtils.copyProperties(employee, employeeDTO);
		employeeDTO.setSkills(employee.getSkills().stream().map(HRMSUtils::entityToDTO).collect(Collectors.toList()));
		return employeeDTO;
	}

	public static SkillDTO entityToDTO(Skill skill) {
		SkillDTO skillDTO = SkillDTO.builder().build();
		BeanUtils.copyProperties(skill, skillDTO);
		return skillDTO;
	}

	public static TrainingProgramDTO entityToDTO(TrainingProgram trainingProgram) {
		TrainingProgramDTO trainingProgramDTO = TrainingProgramDTO.builder().build();
		BeanUtils.copyProperties(trainingProgram, trainingProgramDTO);
		return trainingProgramDTO;
	}

}
