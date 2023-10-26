package com.ty.hrms.service;

import java.util.List;

import com.ty.hrms.dto.SkillDTO;

public interface SkillService {

	List<SkillDTO> fetchAllskill();

	SkillDTO fetchSkillById(Integer skillId);

	Boolean removeSkillById(Integer skillId);


}
