package com.ty.hrms.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

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
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
	@GenericGenerator(name = "employee_sequence", strategy = "com.ty.hrms.custom.EmployeeCustomId")
	private String employeeId;
	private String employeeFirstName;
	private String employeeLastName;
	private String employeeEmailId;
	private Long employeeContactNumber;
	private LocalDate employeeJoiningDate;
	private String employeeDepartment;
	private String employeeDesignation;

	@JoinTable(name = "map_employee_skill", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Skill> skills;

	@JoinTable(name = "map_employee_training_program", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "training_program_id"))
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TrainingProgram> trainingPrograms;

}
