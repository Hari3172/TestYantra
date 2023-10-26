package com.ty.hrms.service.implementation;

import static com.ty.hrms.constants.RolesConstants.ROLE_NOT_FOUND;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.ty.hrms.dto.RegisterDTO;
import com.ty.hrms.entity.AppUser;
import com.ty.hrms.entity.Employee;
import com.ty.hrms.entity.Roles;
import com.ty.hrms.entity.Skill;
import com.ty.hrms.exception.RoleNotFoundException;
import com.ty.hrms.repository.AppUserRepository;
import com.ty.hrms.repository.EmployeeRepository;
import com.ty.hrms.repository.RolesRepository;
import com.ty.hrms.repository.SkillRepository;
import com.ty.hrms.service.HRMSService;
import com.ty.hrms.util.HRMSUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class HRMSServiceImpl implements HRMSService {

	private final EmployeeRepository employeeRepository;
	private final AppUserRepository appUserRepository;
	private final SkillRepository skillRepository;
	private final RolesRepository rolesRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public String register(RegisterDTO registerDTO) {

		Roles roles = rolesRepository.findById("ROLE_EMPLOYEE")
				.orElseThrow(() -> new RoleNotFoundException(ROLE_NOT_FOUND));

		AppUser user = AppUser.builder().username(registerDTO.getEmployeeEmailId())
				.password(passwordEncoder.encode(registerDTO.getPassword())).roles(Lists.newArrayList()).build();

		roles.getAppUsers().add(user);
		user.getRoles().add(roles);

		Employee employee = employeeRepository.save(HRMSUtils.dtoToEntity(registerDTO));

		registerDTO.getSkills().stream().map(skillDTO -> {
			Optional<Skill> skill = skillRepository.findBySkillName(skillDTO.getSkillName());
			if (skill.isPresent()) {
				employee.getSkills().add(skill.get());
			} else {
				employee.getSkills().add(HRMSUtils.dtoToEntity(skillDTO));
			}
			return employee;
		});

		employee.setTrainingPrograms(
				registerDTO.getTrainingPrograms().stream().map(HRMSUtils::dtoToEntity).collect(Collectors.toList()));

		appUserRepository.save(user);

		return employee.getEmployeeId();
	}

}
