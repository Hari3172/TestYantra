package com.ty.hrms.service.implementation;

import static com.ty.hrms.constants.ProgramConstants.PROGRAM_NOT_FOUND;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ty.hrms.dto.TrainingProgramDTO;
import com.ty.hrms.entity.TrainingProgram;
import com.ty.hrms.exception.ProgramNotFoundException;
import com.ty.hrms.repository.TrainingProgramRepository;
import com.ty.hrms.service.TrainingProgramService;
import com.ty.hrms.util.HRMSUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TrainingProgramServiceImpl implements TrainingProgramService {

	private final TrainingProgramRepository trainingProgramRepository;

	@Override
	public List<TrainingProgramDTO> fetchAllTrainingProgram() {
		return trainingProgramRepository.findAll().stream().map(HRMSUtils::entityToDTO).collect(Collectors.toList());
	}

	@Override
	public TrainingProgramDTO fetchTrainingProgramById(Integer trainingProgramId) {
		return HRMSUtils.entityToDTO(trainingProgramRepository.findById(trainingProgramId)
				.orElseThrow(() -> new ProgramNotFoundException(PROGRAM_NOT_FOUND)));
	}

	@Override
	public Boolean removeTrainingProgramById(Integer trainingProgramId) {
		TrainingProgram program = trainingProgramRepository.findById(trainingProgramId)
				.orElseThrow(() -> new ProgramNotFoundException(PROGRAM_NOT_FOUND));
		program.setEmployees(null);
		trainingProgramRepository.delete(program);
		return true;
	}

}
