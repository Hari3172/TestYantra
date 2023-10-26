package com.ty.hrms.entity;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
public class TrainingProgram {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer programId;
	private String programName;
	private String programDescription;
	private LocalDate programStartDate;
	private LocalDate programEndDate;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "trainingPrograms")
	private List<Employee> employees;
}
