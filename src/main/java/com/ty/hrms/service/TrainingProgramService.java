package com.ty.hrms.service;

import java.util.List;

import com.ty.hrms.dto.TrainingProgramDTO;

public interface TrainingProgramService {

	List<TrainingProgramDTO> fetchAllTrainingProgram();

	TrainingProgramDTO fetchTrainingProgramById(Integer trainingProgramId);

	Boolean removeTrainingProgramById(Integer trainingProgramId);

}
