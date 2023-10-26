package com.ty.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hrms.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, String>{

}
