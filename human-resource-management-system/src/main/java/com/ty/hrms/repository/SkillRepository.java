package com.ty.hrms.repository;

import java.util.Optional;

import org.checkerframework.common.aliasing.qual.Unique;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hrms.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

	Optional<Skill> findBySkillName(@Unique String skillName);

}
