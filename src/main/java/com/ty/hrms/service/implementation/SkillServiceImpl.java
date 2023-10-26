package com.ty.hrms.service.implementation;

import static com.ty.hrms.constants.SkillConstants.SKILL_NOT_FOUND;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ty.hrms.dto.SkillDTO;
import com.ty.hrms.entity.Skill;
import com.ty.hrms.exception.SkillNotFoundException;
import com.ty.hrms.repository.SkillRepository;
import com.ty.hrms.service.SkillService;
import com.ty.hrms.util.HRMSUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SkillServiceImpl implements SkillService {

	private final SkillRepository skillRepository;

	@Override
	public List<SkillDTO> fetchAllskill() {
		return skillRepository.findAll().stream().map(HRMSUtils::entityToDTO).collect(Collectors.toList());
	}

	@Override
	public SkillDTO fetchSkillById(Integer skillId) {
		return HRMSUtils.entityToDTO(
				skillRepository.findById(skillId).orElseThrow(() -> new SkillNotFoundException(SKILL_NOT_FOUND)));
	}

	@Override
	public Boolean removeSkillById(Integer skillId) {
		Skill skill = skillRepository.findById(skillId).orElseThrow(() -> new SkillNotFoundException(SKILL_NOT_FOUND));
		skill.setEmployees(null);
		skillRepository.deleteById(skillId);
		return true;
	}

}
